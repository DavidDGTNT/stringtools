package me.daviddgtnt.stringtools;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class StringToolMaterial implements ToolMaterial {
	public static final StringToolMaterial INSTANCE = new StringToolMaterial();
	
	@Override
	public int getDurability() {
		return 1;
	}
	
	@Override
	public float getMiningSpeedMultiplier() {
		return 2.0F;
	}
	
	@Override
	public float getAttackDamage() {
		return 0.0F;
	}
	
	@Override
	public TagKey<Block> getInverseTag() {
		return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
	}
	
	@Override
	public int getEnchantability() {
		return 15;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.STRING);
	}
	
	
}
