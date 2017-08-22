package harry.harrysmod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class HarryTab extends CreativeTabs 
{
	public HarryTab(String label) { super("harry_tab"); }
	public ItemStack getTabIconItem() { return new ItemStack(Items.IRON_INGOT); }
}
