package com.x64;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X64Mod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("x64-mod");

	@Override
	public void onInitialize() {
		EntityJoinWorldCallback.EVENT.register((entity) -> {
			if (entity instanceof ItemEntity itementity) {
				ItemStack item = itementity.getStack();
				item.setCount(item.getCount()*64);
				itementity.setStack(item);
			}
			return ActionResult.SUCCESS;
		});
	}
}