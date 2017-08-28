package harry.harrysmod.world.biome;

import java.util.Random;
import java.util.logging.Logger;

import harry.harrysmod.blocks.CustomBlockDirt;
import harry.harrysmod.blocks.CustomBlockPlanks;
import harry.harrysmod.blocks.CustomBlockSapling;
import harry.harrysmod.init.BlockInit;
import harry.harrysmod.util.Reference;
import harry.harrysmod.world.feature.tree.CopperTree;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeCopper extends Biome
{
	protected static final CopperTree TREE = new CopperTree();
	protected static final IBlockState DIRT = BlockInit.dirt.getDefaultState().withProperty(CustomBlockDirt.VARIANT, CustomBlockPlanks.EnumType.COPPER);
	
	public BiomeCopper()
	{
		super(new BiomeProperties("Copper").setTemperature(1.0F).setBaseHeight(4.0F).setHeightVariation(0.6F).setRainDisabled().setWaterColor(2551650));
		this.topBlock = DIRT;
		this.fillerBlock = DIRT;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 10, 1, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 5, 1, 3));
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) 
	{
		return 2551650;
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) 
	{
		return TREE;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) 
	{
		this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) 
	{
		super.decorate(worldIn, rand, pos);
		Logger.getLogger(Reference.MODID).config(pos.toString());
	}
}
