package harry.harrysmod.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference 
{
	public static final String MODID = "hm";
	public static final String NAME = "Harry's Mod";
	public static final String VERSION = "1.0";
	public static final String CLIENT = "harry.harrysmod.proxy.ClientProxy";
	public static final String COMMON = "harry.harrysmod.proxy.CommonProxy";
	
	public static Logger logger = LogManager.getLogger(Reference.MODID);
	
	public static final int copper_id = 46;
	public static final int copper_dim_id = 740;
}
