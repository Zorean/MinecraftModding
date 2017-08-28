package harry.harrysmod.command;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends Teleporter
{
	private WorldServer world;
	private double x,y,z;
	
	public CustomTeleporter(WorldServer world, double x, double y, double z) 
	{
		super(world);
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) 
	{
		this.world.getBlockState(new BlockPos((int)x, (int)y, (int)z));
		entityIn.setPosition(x, y, z);
		entityIn.motionX = 0;
		entityIn.motionY = 0;
		entityIn.motionZ = 0;
	}
	
	public static void teleport(EntityPlayer player, int dimension, double x, double y, double z)
	{
		int old = player.getEntityWorld().provider.getDimension();
		EntityPlayerMP entity = (EntityPlayerMP) player;
		MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);
        
        if (worldServer == null || worldServer.getMinecraftServer() == null) throw new IllegalArgumentException("Dimension:"+dimension+"doesn't exist!");
        
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entity, dimension, new CustomTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);      
	}
	

}
