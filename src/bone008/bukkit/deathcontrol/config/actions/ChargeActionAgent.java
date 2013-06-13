package bone008.bukkit.deathcontrol.config.actions;

import bone008.bukkit.deathcontrol.config.ActionAgent;
import bone008.bukkit.deathcontrol.config.ActionResult;
import bone008.bukkit.deathcontrol.config.DeathContext;
import bone008.bukkit.deathcontrol.util.EconomyUtil;

public class ChargeActionAgent extends ActionAgent {

	private final ChargeAction action;

	public ChargeActionAgent(DeathContext context, ChargeAction action) {
		super(context, action);
		this.action = action;
	}

	@Override
	public void preprocess() {
	}

	@Override
	public ActionResult execute() {
		double cost;
		if (action.isPercentage) {
			cost = EconomyUtil.calcCost(context.getVictim(), action.money);
			if (cost > action.capMax)
				cost = action.capMax;
			if (cost < action.capMin)
				cost = action.capMin;
		}
		else {
			cost = action.money;
		}

		context.setVariable("money-paid", EconomyUtil.formatMoney(cost));
		context.setVariable("money-paid-raw", cost);
		return (EconomyUtil.payCost(context.getVictim(), cost) ? ActionResult.STANDARD : ActionResult.FAILED);
	}

	@Override
	public void cancel() {
	}

}
