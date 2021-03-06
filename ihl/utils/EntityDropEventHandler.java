package ihl.utils;

import net.minecraft.entity.passive.EntitySheep;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityDropEventHandler 
{
	@SubscribeEvent
	public void onEntityDropEvent(net.minecraftforge.event.entity.living.LivingDropsEvent event)
	{
		if(event.entityLiving instanceof EntitySheep && !event.entityLiving.isChild())
		{
			event.entityLiving.entityDropItem(IHLUtils.getThisModItemStackWithSize("muttonLard", event.entityLiving.worldObj.rand.nextInt(1)+1), 1f);
		}
	}
}
