package harry.harrysmod.world.feature.tree;

import java.util.Random;

import harry.harrysmod.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class CustomAbstractTree extends WorldGenerator
{
	 public CustomAbstractTree(boolean notify) 
	 {
		 super(notify);
	 }
	 
	 	protected boolean canGrowInto(Block blockType)
	    {
	        Material material = blockType.getDefaultState().getMaterial();
	        return material == Material.AIR || material == Material.LEAVES || material == Material.GRASS || blockType == BlockInit.log || blockType == BlockInit.sapling ||blockType == Blocks.VINE;
	    }
	 	
	 	 public void generateSaplings(World worldIn, Random random, BlockPos pos)
		 {
	 		 
		 }
	 	 
	 	 protected void setDirtAt(World worldIn, BlockPos pos)
		    {
		        if (worldIn.getBlockState(pos).getBlock() != Blocks.DIRT)
		        {
		            this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.DIRT.getDefaultState());
		        }
		    }
	 	 
	 	public boolean isReplaceable(World world, BlockPos pos)
	    {
	        net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
	        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos) || state.getBlock().isWood(world, pos) || canGrowInto(state.getBlock());
	    }
}
