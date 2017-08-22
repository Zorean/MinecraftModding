package harry.harrysmod.world.biome;

import harry.harrysmod.blocks.CustomBlockDirt;
import harry.harrysmod.blocks.CustomBlockOre;
import harry.harrysmod.blocks.CustomBlockPlanks;
import harry.harrysmod.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeCopper extends Biome 
{
	private static final IBlockState DIRT = BlockInit.dirt.getDefaultState().withProperty(CustomBlockDirt.VARIANT, CustomBlockPlanks.EnumType.COPPER);
	private static final IBlockState ORE = BlockInit.ore.getDefaultState().withProperty(CustomBlockOre.VARIANT, CustomBlockPlanks.EnumType.COPPER);
	
	public BiomeCopper(BiomeProperties properties) 
	{
		super(properties);
		properties.setBaseHeight(0.5F);
		properties.setHeightVariation(0.25F);
		properties.setTemperature(1.0F);
		properties.setRainDisabled();
		properties.setWaterColor(16753920);
		
		this.topBlock = DIRT;
		this.fillerBlock = DIRT;		
		this.decorator.dirtGen = new WorldGenMinable(DIRT, 16);
		this.decorator.sandGen = new WorldGenMinable(DIRT, 16);
		
		this.decorator.coalGen = new WorldGenMinable(ORE, 16);
		this.decorator.diamondGen = new WorldGenMinable(ORE, 16);
		this.decorator.goldGen = new WorldGenMinable(ORE, 16);
		this.decorator.ironGen = new WorldGenMinable(ORE, 16);
		this.decorator.lapisGen = new WorldGenMinable(ORE, 16);
		this.decorator.redstoneGen = new WorldGenMinable(ORE, 16);
		
		this.decorator.bigMushroomsPerChunk = 0;
		this.decorator.cactiPerChunk = 0;
		this.decorator.clayPerChunk = 0;
		this.decorator.waterlilyPerChunk = 0;
		this.decorator.flowersPerChunk = 0;
		this.decorator.treesPerChunk = 0;
		this.decorator.sandPatchesPerChunk = 0;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityIronGolem.class, 100, 1, 20));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 60, 1, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 80, 1, 10));
	}

}
