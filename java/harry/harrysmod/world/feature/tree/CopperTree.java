package harry.harrysmod.world.feature.tree;

import java.util.Random;

import harry.harrysmod.blocks.CustomBlockLeaves;
import harry.harrysmod.blocks.CustomBlockLog;
import harry.harrysmod.blocks.CustomBlockPlanks;
import harry.harrysmod.blocks.CustomBlockSapling;
import harry.harrysmod.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CopperTree extends CustomAbstractTree
{	
	private static final IBlockState LOG = BlockInit.log.getDefaultState().withProperty(CustomBlockLog.VARIANT, CustomBlockPlanks.EnumType.COPPER);
	private static final IBlockState LEAF = BlockInit.leaves.getDefaultState().withProperty(CustomBlockLeaves.VARIANT, CustomBlockPlanks.EnumType.COPPER).withProperty(CustomBlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	
	private final int minHeight;
	
	public CopperTree(int minHeight) 
	{
		super(false);
		this.minHeight = minHeight;
	}
	
	@Override
	public boolean generate(World world, Random random, BlockPos pos) 
	{
		int height = random.nextInt(3) + this.minHeight;
		boolean flag = true;
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for(int yPos = y; yPos <= y + 1 + height; yPos++)
		{
			int b0 = 2;
			if(yPos == y) b0 = 1;
			if(yPos >= y + 1 + height - 2) b0 = 2;
			
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
			
			for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++)
			{
				for(int zPos = z - b0; zPos <= z + b0 && flag; zPos++)
				{
					if(yPos >= 0 && yPos < world.getHeight())
					{
						if(!this.isReplaceable(world, blockpos$mutableblockpos.setPos(xPos, yPos, zPos)))
						{
							flag = false;
						}
					}
					else
					{
						flag = false;
					}
				}
			}
		}
		
		if(!flag) 
		{
			return false;
		}
		else
		{
			BlockPos down = pos.down();
            IBlockState state = world.getBlockState(down);
            boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (CustomBlockSapling)BlockInit.sapling);
            
            if(isSoil && y < world.getHeight() - height - 1)
            {
            	state.getBlock().onPlantGrow(state, world, down, pos);
            	 
            	
            	for(int yPos2 = y - 3 + height; yPos2 <= y + height; yPos2++)
            	{
            		int b1 = yPos2 - (y + height);
            		int b2 = 1 - b1 / 2;
            		
            		for(int xPos2 = x - b2; xPos2 <= x + b2; xPos2++)
            		{
            			int b3 = xPos2 - x;
            			
            			for(int zPos2 = z - b2; zPos2 <= z + b2; zPos2++)
            			{
            				int b4 = zPos2 - z;
            				
            				if(Math.abs(b3) != b2 || Math.abs(b4) != b2 || random.nextInt(2) != 0 && b1 != 0)
            				{
            					BlockPos pos2 = new BlockPos(xPos2, yPos2, zPos2);
            					IBlockState state2 = world.getBlockState(pos2);
            					if(state2.getBlock().isAir(state2, world, pos2) || state2.getBlock().isAir(state2, world, pos2)) 
            					{
            						this.setBlockAndNotifyAdequately(world, pos2, LEAF);
            						this.setBlockAndNotifyAdequately(world, pos2.add(0, -0.25 * height, 0), LEAF);
            						this.setBlockAndNotifyAdequately(world, pos2.add(0, -0.50 * height, 0), LEAF);
            					}
            				}
            			}
            		}
            	}
            	
            	for (int logHeight = 0; logHeight < height; logHeight++)
                {
                    BlockPos up = pos.up(logHeight);
                    IBlockState state2 = world.getBlockState(up);

                    if (state2.getBlock().isAir(state2, world, up) || state2.getBlock().isLeaves(state2, world, up))
                    {
                        this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
                    }
                }
            	
            	return true;
            }
		}
		return true;
	}	
}