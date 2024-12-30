package me.daviddgtnt.stringtools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class StringToolMaterial {
	public static final ToolMaterial INSTANCE = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1, 2.0F, 0.0F, 15, TagKey.of(RegistryKeys.ITEM, Identifier.of("stringtools", "string")));
}
