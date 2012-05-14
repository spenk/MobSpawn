import java.util.logging.Logger;

public class MobSpawn extends Plugin
{
	  String name = "MobSpawn";
	  String version = "1.0";
	  String author = " spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
	MobSpawnListener listener = new MobSpawnListener();
	listener.loadConfiguration();
log.info(this.name +" version "+ this.version + " by " +this.author+(" is initialized!"));
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
}
public void enable(){
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
	etc.getInstance().addCommand("/mobspawn", "buy yourself a mob");
	etc.getInstance().addCommand("/moblist", "[1|2|3] shows you a list of mobs and prices");
}

public void disable(){
	log.info(this.name + " version " + this.version + " is disabled!");
	etc.getInstance().removeCommand("/mobspawn");
	etc.getInstance().removeCommand("/moblist");
}
}