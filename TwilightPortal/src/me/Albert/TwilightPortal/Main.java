package me.Albert.TwilightPortal;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	private YamlConfiguration config;
	private File file = new File(this.getDataFolder() , "config.yml");;
	@Override
	public void onEnable() {
		org.bukkit.Bukkit.getConsoleSender().sendMessage("§a[TwilightPortal] Loaded");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		 this.saveDefaultConfig();
		 this.config = YamlConfiguration.loadConfiguration(this.file);
		 new Metrics(this);	
	};
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!new File(this.getDataFolder(),"config.yml").exists()) {
		saveResource("config.yml", true);
		} else
		this.config = YamlConfiguration.loadConfiguration(this.file);
		sender.sendMessage("§a[TwilightPortal] config reloaded");
		return true;
	}
	@EventHandler
	public void PortalDetect(PlayerDropItemEvent event) {
		org.bukkit.entity.Item i = event.getItemDrop();
		if (i instanceof Item && ((Item) i).getItemStack().getType() == Material.DIAMOND && config.getList("Enabledworlds").contains(i.getWorld().getName())) {
			
			getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
			  if (i.getLocation().getBlock().getType() == Material.WATER || i.getLocation().getBlock().getType() == Material.STATIONARY_WATER) {
				 Block b1 = i.getLocation().getBlock().getRelative(0,0,1);
				 Block b2 = i.getLocation().getBlock().getRelative(0,0,-1);
				 Block b3 = i.getLocation().getBlock().getRelative(1,0,0);
				 Block b4 = i.getLocation().getBlock().getRelative(-1,0,0);
				 Block b5 = i.getLocation().getBlock().getRelative(1,0,1);
				 Block b6 = i.getLocation().getBlock().getRelative(-1,0,-1);
				 Block b7 = i.getLocation().getBlock().getRelative(-1,0,1);
				 Block b8 = i.getLocation().getBlock().getRelative(1,0,-1);
				 
				  if (b1.getType() == Material.WATER && b5.getType() == Material.WATER && b3.getType() == Material.WATER
						  || b1.getType() == Material.STATIONARY_WATER && 
						  b5.getType() == Material.STATIONARY_WATER && b3.getType() == Material.STATIONARY_WATER) {
					 
					  Material g1 = i.getLocation().getBlock().getRelative(0,1,-1).getType();
					  Material g2 = i.getLocation().getBlock().getRelative(-1,1,-1).getType();
					  Material g3 = i.getLocation().getBlock().getRelative(-1,1,0).getType();
					  Material g4 = i.getLocation().getBlock().getRelative(-1,1,1).getType();
					  Material g5 = i.getLocation().getBlock().getRelative(-1,1,2).getType();
					  Material g6 = i.getLocation().getBlock().getRelative(0,1,2).getType();
					  Material g7 = i.getLocation().getBlock().getRelative(1,1,2).getType();
					  Material g8 = i.getLocation().getBlock().getRelative(2,1,2).getType();
					  Material g9 = i.getLocation().getBlock().getRelative(2,1,1).getType();
					  Material g10 = i.getLocation().getBlock().getRelative(2,1,0).getType();
					  Material g11 = i.getLocation().getBlock().getRelative(2,1,-1).getType();
					  Material g12 = i.getLocation().getBlock().getRelative(1,1,-1).getType();
					  if (isFlower(g1) && isFlower(g2) &&isFlower(g3) &&
							  isFlower(g4) &&isFlower(g5) &&isFlower(g6) &&isFlower(g7) &&
							  isFlower(g8) &&isFlower(g9) &&isFlower(g10) &&isFlower(g11) &&
							  isFlower(g12) ) {
						  i.getLocation().getBlock().setType(Material.ENDER_PORTAL);
						  b1.setType(Material.ENDER_PORTAL);
						  b5.setType(Material.ENDER_PORTAL);
						  b3.setType(Material.ENDER_PORTAL);
						  event.getItemDrop().getLocation().getWorld().strikeLightning(i.getLocation());
						  Bukkit.getConsoleSender().sendMessage("[TwilightPortal] Player "+event.getPlayer().getName()
								  + " created a portal at world " + event.getItemDrop().getWorld().getName()+" x: "+event.getItemDrop().getLocation().getX()
								  +" y: "+event.getItemDrop().getLocation().getY()
								  +" z: "+event.getItemDrop().getLocation().getZ());
					  }
				  }
                 if (b4.getType() == Material.WATER && b1.getType() == Material.WATER && b7.getType() == Material.WATER
                		 || b4.getType() == Material.STATIONARY_WATER && 
						  b1.getType() == Material.STATIONARY_WATER && b7.getType() == Material.STATIONARY_WATER) {
                	 
                	 Material g1 = i.getLocation().getBlock().getRelative(-1,1,-1).getType();
					  Material g2 = i.getLocation().getBlock().getRelative(-2,1,-1).getType();
					  Material g3 = i.getLocation().getBlock().getRelative(-2,1,0).getType();
					  Material g4 = i.getLocation().getBlock().getRelative(-2,1,1).getType();
					  Material g5 = i.getLocation().getBlock().getRelative(-2,1,2).getType();
					  Material g6 = i.getLocation().getBlock().getRelative(-1,1,2).getType();
					  Material g7 = i.getLocation().getBlock().getRelative(0,1,2).getType();
					  Material g8 = i.getLocation().getBlock().getRelative(1,1,2).getType();
					  Material g9 = i.getLocation().getBlock().getRelative(1,1,1).getType();
					  Material g10 = i.getLocation().getBlock().getRelative(1,1,0).getType();
					  Material g11 = i.getLocation().getBlock().getRelative(1,1,-1).getType();
					  Material g12 = i.getLocation().getBlock().getRelative(0,1,-1).getType();
					  if (isFlower(g1) && isFlower(g2) &&isFlower(g3) &&
							  isFlower(g4) &&isFlower(g5) &&isFlower(g6) &&isFlower(g7) &&
							  isFlower(g8) &&isFlower(g9) &&isFlower(g10) &&isFlower(g11) &&
							  isFlower(g12) ) {
						  i.getLocation().getBlock().setType(Material.ENDER_PORTAL);
						  b4.setType(Material.ENDER_PORTAL);
						  b1.setType(Material.ENDER_PORTAL);
						  b7.setType(Material.ENDER_PORTAL);
						  event.getItemDrop().getLocation().getWorld().strikeLightning(i.getLocation());
						  Bukkit.getConsoleSender().sendMessage("[TwilightPortal] Player "+event.getPlayer().getName()
								  + " created a portal at world " + event.getItemDrop().getWorld().getName()+" x: "+event.getItemDrop().getLocation().getX()
								  +" y: "+event.getItemDrop().getLocation().getY()
								  +" z: "+event.getItemDrop().getLocation().getZ());
					  }
				  }
                 if (b2.getType() == Material.WATER && b3.getType() == Material.WATER && b8.getType()== Material.WATER
                		 || b2.getType() == Material.STATIONARY_WATER && 
						  b3.getType() == Material.STATIONARY_WATER && b8.getType() == Material.STATIONARY_WATER) {
                	
                	 Material g1 = i.getLocation().getBlock().getRelative(0,1,-2).getType();
					  Material g2 = i.getLocation().getBlock().getRelative(-1,1,-2).getType();
					  Material g3 = i.getLocation().getBlock().getRelative(-1,1,-1).getType();
					  Material g4 = i.getLocation().getBlock().getRelative(-1,1,0).getType();
					  Material g5 = i.getLocation().getBlock().getRelative(-1,1,1).getType();
					  Material g6 = i.getLocation().getBlock().getRelative(0,1,1).getType();
					  Material g7 = i.getLocation().getBlock().getRelative(1,1,1).getType();
					  Material g8 = i.getLocation().getBlock().getRelative(2,1,1).getType();
					  Material g9 = i.getLocation().getBlock().getRelative(2,1,0).getType();
					  Material g10 = i.getLocation().getBlock().getRelative(2,1,-1).getType();
					  Material g11 = i.getLocation().getBlock().getRelative(2,1,-2).getType();
					  Material g12 = i.getLocation().getBlock().getRelative(1,1,-2).getType();
					  if (isFlower(g1) && isFlower(g2) &&isFlower(g3) &&
							  isFlower(g4) &&isFlower(g5) &&isFlower(g6) &&isFlower(g7) &&
							  isFlower(g8) &&isFlower(g9) &&isFlower(g10) &&isFlower(g11) &&
							  isFlower(g12) ) {
						  i.getLocation().getBlock().setType(Material.ENDER_PORTAL);
						  b2.setType(Material.ENDER_PORTAL);
						  b3.setType(Material.ENDER_PORTAL);
						  b8.setType(Material.ENDER_PORTAL);
						  event.getItemDrop().getLocation().getWorld().strikeLightning(i.getLocation());
						  Bukkit.getConsoleSender().sendMessage("[TwilightPortal] Player "+event.getPlayer().getName()
								  + " created a portal at world " + event.getItemDrop().getWorld().getName()+" x: "+event.getItemDrop().getLocation().getX()
								 +" y: "+event.getItemDrop().getLocation().getY()
								 +" z: "+event.getItemDrop().getLocation().getZ());
					  }
				  }
                 if (b4.getType() == Material.WATER && b2.getType() == Material.WATER && b6.getType() == Material.WATER
                		 || b4.getType() == Material.STATIONARY_WATER && 
						  b2.getType() == Material.STATIONARY_WATER && b6.getType() == Material.STATIONARY_WATER) {
                	 
                	 Material g1 = i.getLocation().getBlock().getRelative(-1,1,-2).getType();
					  Material g2 = i.getLocation().getBlock().getRelative(-2,1,-2).getType();
					  Material g3 = i.getLocation().getBlock().getRelative(-2,1,-1).getType();
					  Material g4 = i.getLocation().getBlock().getRelative(-2,1,0).getType();
					  Material g5 = i.getLocation().getBlock().getRelative(-2,1,1).getType();
					  Material g6 = i.getLocation().getBlock().getRelative(-1,1,1).getType();
					  Material g7 = i.getLocation().getBlock().getRelative(0,1,1).getType();
					  Material g8 = i.getLocation().getBlock().getRelative(1,1,1).getType();
					  Material g9 = i.getLocation().getBlock().getRelative(1,1,0).getType();
					  Material g10 = i.getLocation().getBlock().getRelative(1,1,-1).getType();
					  Material g11 = i.getLocation().getBlock().getRelative(1,1,-2).getType();
					  Material g12 = i.getLocation().getBlock().getRelative(0,1,-2).getType();
					  if (isFlower(g1) && isFlower(g2) &&isFlower(g3) &&
							  isFlower(g4) &&isFlower(g5) &&isFlower(g6) &&isFlower(g7) &&
							  isFlower(g8) &&isFlower(g9) &&isFlower(g10) &&isFlower(g11) &&
							  isFlower(g12) ) {
						  i.getLocation().getBlock().setType(Material.ENDER_PORTAL);
						  b4.setType(Material.ENDER_PORTAL);
						  b2.setType(Material.ENDER_PORTAL);
						  b6.setType(Material.ENDER_PORTAL);
						  event.getItemDrop().getLocation().getWorld().strikeLightning(i.getLocation());
						  Bukkit.getConsoleSender().sendMessage("[TwilightPortal] Player"+event.getPlayer().getName()
								  + "created a portal at world " + event.getItemDrop().getWorld().getName()+" x: "+event.getItemDrop().getLocation().getX()
								  +" y: "+event.getItemDrop().getLocation().getY()
								  +" z: "+event.getItemDrop().getLocation().getZ());
					  }
				  }
			  }
				}
				}, 40L);
		}
		
	}
	@EventHandler
    public void onPortal(PlayerPortalEvent event) {
        if(event.getCause() == TeleportCause.END_PORTAL ) {
        	Material m1 = event.getFrom().getBlock().getRelative(-2,0,0).getType();
        	Material m2 = event.getFrom().getBlock().getRelative(2,0,0).getType();
        	Material m3 = event.getFrom().getBlock().getRelative(0,0,2).getType();
        	Material m4 = event.getFrom().getBlock().getRelative(0,0,-2).getType();
        	Material m5 = event.getFrom().getBlock().getRelative(1,0,0).getType();
        	Material m6 = event.getFrom().getBlock().getRelative(-1,0,0).getType(); 
        	if (m5 == Material.ENDER_PORTAL && m6 == Material.ENDER_PORTAL ) {
        		
        	} else
        	if (m1 != Material.ENDER_PORTAL && m2  != Material.ENDER_PORTAL &&
        			m3 != Material.ENDER_PORTAL && m4 != Material.ENDER_PORTAL ) {
        		event.setCancelled(true);
        		event.getPlayer().teleport(new Location(Bukkit.getWorld(config.getString("world")), config.getDouble("x"), 
        				config.getDouble("y"), config.getDouble("z")));
        		
        	}
          
        }

}
	 @EventHandler
	    public void onPlayerMineBlock(BlockBreakEvent event){
		Block b1 = event.getBlock().getRelative(1,0,0);
		Block b2 = event.getBlock().getRelative(0,0,1);
		Block b3 = event.getBlock().getRelative(-1,0,0);
		Block b4 = event.getBlock().getRelative(0,0,-1);
     	if (b1.getType() == Material.ENDER_PORTAL) {
     		b1.breakNaturally();
     		if (b1.getRelative(0,0,1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(0,0,1).breakNaturally();
     		}
     		if (b1.getRelative(0,0,-1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(0,0,-1).breakNaturally();
     		}
     		if (b1.getRelative(1,0,0).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(1,0,0).breakNaturally();
     		}
     		if (b1.getRelative(-1,0,0).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(-1,0,0).breakNaturally();
     		}
     		if (b1.getRelative(1,0,1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(1,0,1).breakNaturally();
     		}
     		if (b1.getRelative(-1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(-1,0,-1).breakNaturally();
     		}
     		if (b1.getRelative(-1,0,1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(-1,0,1).breakNaturally();
     		}
     		if (b1.getRelative(1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b1.getRelative(1,0,-1).breakNaturally();
     		}
     	}
     	if (b2.getType() == Material.ENDER_PORTAL) {
     		event.getBlock().getRelative(0,0,1).breakNaturally();
     		if (b2.getRelative(0,0,1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(0,0,1).breakNaturally();
     		}
     		if (b2.getRelative(0,0,-1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(0,0,-1).breakNaturally();
     		}
     		if (b2.getRelative(1,0,0).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(1,0,0).breakNaturally();
     		}
     		if (b2.getRelative(-1,0,0).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(-1,0,0).breakNaturally();
     		}
     		if (b2.getRelative(1,0,1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(1,0,1).breakNaturally();
     		}
     		if (b2.getRelative(-1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(-1,0,-1).breakNaturally();
     		}
     		if (b2.getRelative(-1,0,1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(-1,0,1).breakNaturally();
     		}
     		if (b2.getRelative(1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b2.getRelative(1,0,-1).breakNaturally();
     		}
     	}
     	if (b3.getType() == Material.ENDER_PORTAL) {
     		event.getBlock().getRelative(-1,0,0).breakNaturally();
     		if (b3.getRelative(0,0,1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(0,0,1).breakNaturally();
     		}
     		if (b3.getRelative(0,0,-1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(0,0,-1).breakNaturally();
     		}
     		if (b3.getRelative(1,0,0).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(1,0,0).breakNaturally();
     		}
     		if (b3.getRelative(-1,0,0).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(-1,0,0).breakNaturally();
     		}
     		if (b3.getRelative(1,0,1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(1,0,1).breakNaturally();
     		}
     		if (b3.getRelative(-1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(-1,0,-1).breakNaturally();
     		}
     		if (b3.getRelative(-1,0,1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(-1,0,1).breakNaturally();
     		}
     		if (b3.getRelative(1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b3.getRelative(1,0,-1).breakNaturally();
     		}
     	}
     	if (b4.getType() == Material.ENDER_PORTAL) {
     		event.getBlock().getRelative(0,0,-1).breakNaturally();
     		if (b4.getRelative(0,0,1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(0,0,1).breakNaturally();
     		}
     		if (b4.getRelative(0,0,-1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(0,0,-1).breakNaturally();
     		}
     		if (b4.getRelative(1,0,0).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(1,0,0).breakNaturally();
     		}
     		if (b4.getRelative(-1,0,0).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(-1,0,0).breakNaturally();
     		}
     		if (b4.getRelative(1,0,1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(1,0,1).breakNaturally();
     		}
     		if (b4.getRelative(-1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(-1,0,-1).breakNaturally();
     		}
     		if (b4.getRelative(-1,0,1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(-1,0,1).breakNaturally();
     		}
     		if (b4.getRelative(1,0,-1).getType() == Material.ENDER_PORTAL) {
     			b4.getRelative(1,0,-1).breakNaturally();
     		}
     	}
	 }
	 public static boolean isFlower(Material b) {
		 if (b == Material.YELLOW_FLOWER || b == Material.RED_ROSE
				 || b == Material.DOUBLE_PLANT  || b == Material.BROWN_MUSHROOM
				 || b == Material.RED_MUSHROOM|| b == Material.DEAD_BUSH ) {
			 return true;
		 } else
		return false;
		 
	 }
	 
	 
	 
}
