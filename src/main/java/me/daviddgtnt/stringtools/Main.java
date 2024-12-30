package me.daviddgtnt.stringtools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	public static final Item STRING_STICK = new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools","string_stick" ))));
	public static final SwordItem STRING_SWORD = new SwordItem(StringToolMaterial.INSTANCE, 4, 1.6F, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string_sword"))));
	public static final MiningToolItem STRING_PICKAXE = new PickaxeItem(StringToolMaterial.INSTANCE, 2.0F, 2.4F, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string_pickaxe"))));
	public static final MiningToolItem STRING_AXE = new AxeItem(StringToolMaterial.INSTANCE, 7.0F, 0.8F, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string_axe"))));
	public static final MiningToolItem STRING_SHOVEL = new ShovelItem(StringToolMaterial.INSTANCE, 2.5F, 1.0F, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string_shovel"))));
	public static final MiningToolItem STRING_HOE = new HoeItem(StringToolMaterial.INSTANCE, 1.0F, 1.0F, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string_hoe"))));
	
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_stick"), STRING_STICK);
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_sword"), STRING_SWORD);
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_pickaxe"), STRING_PICKAXE);
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_axe"), STRING_AXE);
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_shovel"), STRING_SHOVEL);
		Registry.register(Registries.ITEM, Identifier.of("stringtools", "string_hoe"), STRING_HOE);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addBefore(Items.STICK, STRING_STICK));

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
