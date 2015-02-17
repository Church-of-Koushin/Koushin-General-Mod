package jp.koushin_lawfirm.www.item;

import jp.koushin_lawfirm.www.entity.Entity6Char;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Item6Char extends Item {

	public Item6Char() {
		super();
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("6Char");
		this.setTextureName("koushingeneralmod:sixchar");
		this.setMaxStackSize(16);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			--itemStack.stackSize;
		}

		world.playSoundAtEntity(player, "random.bow", 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!world.isRemote) {
			world.spawnEntityInWorld(new Entity6Char(world, player));
		}

		return itemStack;
	}

}
