package jp.koushin_lawfirm.www.block;

import jp.koushin_lawfirm.www.entity.EntityNukePrimed;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTNTNuke extends BlockTNT {
	@SideOnly(Side.CLIENT)
	private IIcon TopIcon;

	@SideOnly(Side.CLIENT)
	private IIcon BottomIcon;

	@SideOnly(Side.CLIENT)
	private IIcon SideIcon;

	public BlockTNTNuke() {
		super();
		this.setBlockName("tntNuke");
		this.setStepSound(Block.soundTypeGrass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.TopIcon = iconRegister.registerIcon("koushingeneralmod:nuke_top");
		this.BottomIcon = iconRegister
				.registerIcon("koushingeneralmod:nuke_bottom");
		this.SideIcon = Blocks.tnt.getBlockTextureFromSide(2);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int loc, int p_149691_2_) {
		if (loc == 0) {
			return BottomIcon;
		}
		if (loc == 1) {
			return TopIcon;
		}
		if (loc == 2 || loc == 3 || loc == 4 || loc == 5 || loc == 6) {
			return SideIcon;
		} else {
			return null;
		}
	}

	@Override
    public void func_150114_a(World world, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
    {
        if (!world.isRemote)
        {
            if ((p_150114_5_ & 1) == 1)
            {
                EntityNukePrimed entityNukePrimed = new EntityNukePrimed(world, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
                world.spawnEntityInWorld(entityNukePrimed);
                world.playSoundAtEntity(entityNukePrimed, "game.tnt.primed", 1.0F, 1.0F);
            }
        }
    }


}
