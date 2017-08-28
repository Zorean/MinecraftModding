package harry.harrysmod.command;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import harry.harrysmod.util.Reference;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentScore;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class DimensionTP extends CommandBase
{
	private final List<String> aliases;
	
	public DimensionTP() 
	{
		aliases = Lists.newArrayList(Reference.MODID, "TP", "tp");
	}
	
	@Override
	public String getName() 
	{
		return "tp";
	}
	
	@Override
	public String getUsage(ICommandSender sender)
	{
		return "tp <id>";
	}
	
	@Override
	public List<String> getAliases() 
	{
		return aliases;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length < 1) return;
		
		String s = args[0];
		int dimension;
		
		try
		{
			dimension = Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Error Parsing dimension!"));
			return;
		}
		
		if(sender instanceof EntityPlayer)
		{
			CustomTeleporter.teleport((EntityPlayer) sender, dimension, 0, 100, 0);
		}
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		return true;
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) 
	{
		return Collections.emptyList();
	}
}
