package harry.harrysmod.init;

import harry.harrysmod.Main;
import harry.harrysmod.blocks.CustomBlockDirt;
import harry.harrysmod.blocks.CustomBlockGrass;
import harry.harrysmod.blocks.CustomBlockLeaves;
import harry.harrysmod.blocks.CustomBlockLog;
import harry.harrysmod.blocks.CustomBlockOre;
import harry.harrysmod.blocks.CustomBlockPlanks;
import harry.harrysmod.blocks.CustomBlockSapling;
import harry.harrysmod.blocks.item.CustomItemBlockVariants;
import harry.harrysmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit 
{
	public static Block planks, log, leaves, sapling, dirt, ore;
	
	public static void init()
	{
		planks = new CustomBlockPlanks("planks");
		log = new CustomBlockLog("log");
		leaves = new CustomBlockLeaves("leaves");
		sapling = new CustomBlockSapling("sapling");
		dirt = new CustomBlockDirt("dirt");
		ore = new CustomBlockOre("ore");
	}
	
	public static void register()
	{
		registerBlock(planks, new CustomItemBlockVariants(planks));
		registerBlock(log, new CustomItemBlockVariants(log));
		registerBlock(leaves, new CustomItemBlockVariants(leaves));
		registerBlock(sapling, new CustomItemBlockVariants(sapling));
		registerBlock(dirt, new CustomItemBlockVariants(dirt));
		registerBlock(ore, new CustomItemBlockVariants(ore));
	}
	
	public static void registerRenders()
	{
		for(int i = 0; i < CustomBlockPlanks.EnumType.values().length; i++)
		{
			registerRender(planks, i, "planks_" + CustomBlockPlanks.EnumType.values()[i].getName());
			registerRender(log, i, "log_" + CustomBlockPlanks.EnumType.values()[i].getName());
			registerRender(leaves, i, "leaves_" + CustomBlockPlanks.EnumType.values()[i].getName());
			registerRender(sapling, i, "sapling_" + CustomBlockPlanks.EnumType.values()[i].getName());
			registerRender(dirt, i, "dirt_" + CustomBlockPlanks.EnumType.values()[i].getName());
			registerRender(ore, i, "ore_" + CustomBlockPlanks.EnumType.values()[i].getName());
		}
	}
	
	public static void registerBlock(Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Main.harry_tab);
		ItemBlock item = new  ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void registerBlock(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(Main.harry_tab);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
	}
	
	public static void registerRender(Block block, int meta, String filename)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), "inventory"));
	}
}
