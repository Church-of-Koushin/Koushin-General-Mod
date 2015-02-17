package jp.koushin_lawfirm.www.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityLawyer extends EntityMob {
	public EntityLawyer(World world) {
		super(world);
	}

	@Override
	public void dropFewItems(boolean doesPlayerKill, int level) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + level);

		for (int k = 0; k < j; ++k) {

			this.dropItem(Items.porkchop, 1);
		}
	}
}
