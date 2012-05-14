public class MobSpawnListener extends PluginListener {
	  private PropertiesFile properties = new PropertiesFile("MobSpawn.properties");
	  private double Sheep;
	  private double MushroomCow;
	  private double Skeleton;
	  private double Creeper;
	  private double PigZombie;
	  private double Pig;
	  private double Villager;
	  private double Slime;
	  private double Silverfish;
	  private double Squid;
	  private double Wolf;
	  private double Chicken;
	  private double Cow;
	  private double Zombie;
	  private double Enderman;
	  private double Giant;
	  private double Ghast;
	  private double Spider;
	  private double CaveSpider;
	  private double LavaSlime;
	  private double SnowMan;
	  
	  
	public void loadConfiguration() {
		Sheep = properties.getDouble("Sheep", 100.0D);
		MushroomCow = properties.getDouble("MushroomCow", 100.0D);
		Skeleton = properties.getDouble("Skeleton", 100.0D);
		Creeper = properties.getDouble("Creeper", 100.0D);
		PigZombie = properties.getDouble("PigZombie", 100.0D);
		Pig = properties.getDouble("Pig", 100.0D);
		Villager = properties.getDouble("Villager", 100.0D);
		Slime = properties.getDouble("Slime", 100.0D);
		Silverfish = properties.getDouble("Silverfish", 100.0D);
		Squid = properties.getDouble("Squid", 100.0D);
		Wolf = properties.getDouble("Wolf", 100.0D);
		Chicken = properties.getDouble("Chicken", 100.0D);
		Cow = properties.getDouble("Cow", 100.0D);
		Zombie = properties.getDouble("Zombie", 100.0D);
		Enderman = properties.getDouble("Enderman", 100.0D);
		Spider = properties.getDouble("Spider", 100.0D);
		CaveSpider = properties.getDouble("CaveSpider", 100.0D);
		LavaSlime = properties.getDouble("LavaSlime", 100.0D);
		Giant = properties.getDouble("Giant", 100.0D);
		SnowMan = properties.getDouble("SnowMan", 100.0D);
		Ghast = properties.getDouble("Ghast", 100.0D);
	  }
	public boolean onCommand(Player player,java.lang.String[] split){
		String currency = (String) etc.getLoader().callCustomHook("dCBalance", new Object[] { "MoneyName" });
		if((split[0].equals("/moblist"))){
			if (split.length == 1){
				player.sendMessage("§3moblist 1/3");
				player.sendMessage("§6Sheep / price =" + Sheep +currency);
				player.sendMessage("§6MushroomCow / price =" + MushroomCow +currency);
				player.sendMessage("§6Skeleton / price =" + Skeleton +currency);
				player.sendMessage("§6Creeper / price =" + Creeper+currency);
				player.sendMessage("§6PigZombie / price =" +PigZombie +currency);
				player.sendMessage("§6Pig / price =" +Pig +currency);
				player.sendMessage("§6Villager / price ="+Villager +currency);
				return true;
			}else{
			if ((split.length <2)||(split.length >2)){
				player.sendMessage("§cusage - /moblist");
				return true;
			}else{
				if (split[1].equals("1")){
				player.sendMessage("§3moblist 1/3");
				player.sendMessage("§6Sheep / price =" + Sheep +currency);
				player.sendMessage("§6MushroomCow / price =" + MushroomCow +currency);
				player.sendMessage("§6Skeleton / price =" + Skeleton +currency);
				player.sendMessage("§6Creeper / price =" + Creeper+currency);
				player.sendMessage("§6PigZombie / price =" +PigZombie +currency);
				player.sendMessage("§6Pig / price =" +Pig +currency);
				player.sendMessage("§6Villager / price ="+Villager +currency);
				return true;
				} 
				if (split[1].equals("2")){
					player.sendMessage("§3moblist 2/3");
					player.sendMessage("§6Slime / price ="+Slime +currency);
					player.sendMessage("§6Silverfish / price ="+Silverfish +currency);
					player.sendMessage("§6Squid / price ="+Squid +currency);
					player.sendMessage("§6Wolf / price ="+Wolf +currency);
					player.sendMessage("§6Chicken / price ="+Chicken +currency);
					player.sendMessage("§6Cow / price ="+Cow +currency);
					player.sendMessage("§6Zombie / price ="+Zombie +currency);
					return true;
				} 
				if (split[1].equals("3")){
					player.sendMessage("§3moblist 3/3");
					player.sendMessage("§6Enderman / price ="+Enderman+currency);
					player.sendMessage("§6Spider / price ="+Spider+currency);
					player.sendMessage("§6CaveSpider / price ="+CaveSpider+currency);
					player.sendMessage("§6LavaSlime / price ="+LavaSlime+currency);
					player.sendMessage("§6Giant / price ="+Giant+currency);
					player.sendMessage("§6SnowMan / price ="+SnowMan+currency);
					player.sendMessage("§6Ghast / price ="+Ghast+currency);
					return true;
				}
			}
		}
		}
		if((split[0].equalsIgnoreCase("/mobspawn"))&&(player.canUseCommand("/mobspawn"))){
			if ((split.length <2)||(split.length >2)){
				player.sendMessage("§cusage /mobspawn 'mob'");
				return true;
			}else{
			double money = (Double)etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Balance", player.getName()});
			if ((!split[1].equals("Sheep"))&&(!split[1].equals("MushroomCow"))&&(!split[1].equals("Skeleton"))&&(!split[1].equals("Creeper"))&&(!split[1].equals("PigZombie"))&&(!split[1].equals("Pig"))
					&&(!split[1].equals("Villager"))&&(!split[1].equals("Slime"))&&(!split[1].equals("Silverfish"))&&(!split[1].equals("Squid"))&&(!split[1].equals("Wolf"))&&(!split[1].equals("Chicken"))
					&&(!split[1].equals("Cow"))&&(!split[1].equals("Zombie"))&&(!split[1].equals("Enderman"))&&(!split[1].equals("Spider"))&&(!split[1].equals("CaveSpider"))&&(!split[1].equals("LavaSlime"))
					&&(!split[1].equals("Giant"))&&(!split[1].equals("SnowMan"))&&(!split[1].equals("Ghast"))){
				player.sendMessage("§4Mob not found.");
				return true;
			}else{
			if (split[1].equals("Sheep")){
				if (money < Sheep){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Sheep});
			Mob mob = new Mob("Sheep", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("MushroomCow")){
				if (money < MushroomCow){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) MushroomCow});
			Mob mob = new Mob("MushroomCow", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Skeleton")){
				if (money < Skeleton){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Skeleton});
			Mob mob = new Mob("Skeleton", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Creeper")){
				if (money < Creeper){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Creeper});
			Mob mob = new Mob("Creeper", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("PigZombie")){
				if (money < PigZombie){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) PigZombie});
			Mob mob = new Mob("PigZombie", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Pig")){
				if (money < Pig){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Pig});
			Mob mob = new Mob("pig", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Villager")){
				if (money < Villager){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Villager});
			Mob mob = new Mob("Villager", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Slime")){
				if (money < Slime){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Slime});
			Mob mob = new Mob("Slime", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Silverfish")){
				if (money < Silverfish){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Silverfish});
			Mob mob = new Mob("Silverfish", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Squid")){
				if (money < Squid){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Squid});
			Mob mob = new Mob("Squid", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Wolf")){
				if (money < Wolf){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Wolf});
			Mob mob = new Mob("Wolf", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Chicken")){
				if (money < Chicken){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Chicken});
			Mob mob = new Mob("Chicken", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Cow")){
				if (money < Cow){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Cow});
			Mob mob = new Mob("Cow", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Zombie")){
				if (money < Zombie){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Zombie});
			Mob mob = new Mob("Zombie", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Enderman")){
				if (money < Enderman){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Enderman});
			Mob mob = new Mob("Enderman", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Spider")){
				if (money < Spider){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Spider});
			Mob mob = new Mob("Spider", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("CaveSpider")){
				if (money < CaveSpider){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) CaveSpider});
			Mob mob = new Mob("CaveSpider", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("LavaSlime")){
				if (money < LavaSlime){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) LavaSlime});
			Mob mob = new Mob("LavaSlime", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Giant")){
				if (money < Giant){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Giant});
			Mob mob = new Mob("Giant", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("SnowMan")){
				if (money < SnowMan){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) SnowMan});
			Mob mob = new Mob("SnowMan", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
			
			if (split[1].equals("Ghast")){
				if (money < Ghast){
					player.sendMessage("§4You cant afford this");
					return true;
				}else{
					etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Charge", player.getName(), (Double) Ghast});
			Mob mob = new Mob("Ghast", player.getLocation());
			mob.spawn();
			player.sendMessage("§2mob spawned");
			return true;
			}
			}
	}
		}
		}
		return false;
}
	}