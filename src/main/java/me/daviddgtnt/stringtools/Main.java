package me.daviddgtnt.stringtools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	public static final Item STRING_STICK = new Item(new FabricItemSettings());
	public static final ToolItem STRING_SWORD = new SwordItem(StringToolMaterial.INSTANCE, 4, 1.6F, new Item.Settings());
	public static final ToolItem STRING_PICKAXE = new CustomPickaxeItem(StringToolMaterial.INSTANCE, 2, 2.4F, new Item.Settings());
	public static final ToolItem STRING_AXE = new CustomAxeItem(StringToolMaterial.INSTANCE, 7.0F, 0.8F, new Item.Settings());
	public static final ToolItem STRING_SHOVEL = new ShovelItem(StringToolMaterial.INSTANCE, 2.5F, 1F, new Item.Settings());
	public static final ToolItem STRING_HOE = new CustomHoeItem(StringToolMaterial.INSTANCE, 1, 1.0F, new Item.Settings());
	
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_stick"), STRING_STICK);
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_sword"), STRING_SWORD);
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_pickaxe"), STRING_PICKAXE);
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_axe"), STRING_AXE);
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_shovel"), STRING_SHOVEL);
		Registry.register(Registries.ITEM, new Identifier("stringtools", "string_hoe"), STRING_HOE);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addBefore(Items.STICK, STRING_STICK);
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.addBefore(Items.WOODEN_SHOVEL, STRING_HOE);
			content.addBefore(STRING_HOE, STRING_AXE);
			content.addBefore(STRING_AXE, STRING_PICKAXE);
			content.addBefore(STRING_PICKAXE, STRING_SHOVEL);
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addBefore(Items.WOODEN_SWORD, STRING_SWORD);
			content.addBefore(Items.WOODEN_AXE, STRING_AXE);
		});
	}
}
