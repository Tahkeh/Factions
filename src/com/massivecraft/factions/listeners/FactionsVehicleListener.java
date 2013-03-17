package com.massivecraft.factions.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.metadata.FixedMetadataValue;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.P;


public class FactionsVehicleListener implements Listener
{
	public P p;
	public FactionsVehicleListener(P p)
	{
		this.p = p;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleCreate(VehicleCreateEvent event)
	{
		Vehicle vehicle = event.getVehicle();
		if (vehicle instanceof ExplosiveMinecart) {
			Location loc = vehicle.getLocation();
			Faction faction = Board.getFactionAt(new FLocation(loc));
			vehicle.setMetadata("placedInFaction", new FixedMetadataValue(p, faction.getId()));
		}
	}
}