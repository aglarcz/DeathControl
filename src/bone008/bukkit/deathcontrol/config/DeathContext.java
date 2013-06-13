package bone008.bukkit.deathcontrol.config;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import bone008.bukkit.deathcontrol.StoredItemStack;

public interface DeathContext {

	public Location getDeathLocation();

	public Player getVictim();

	public List<StoredItemStack> getItemDrops();

	public PlayerDeathEvent getDeathEvent();

	public String replaceVariables(CharSequence input);

	public Object getVariable(String name);

	public void setVariable(String name, Object value);

	public boolean continueExecution(ActionResult reason);

	public void cancel();

}
