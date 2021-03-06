package com.creativemd.littletiles.common.structure;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.creativemd.creativecore.common.entity.EntitySit;
import com.creativemd.creativecore.common.utils.HashMapList;
import com.creativemd.creativecore.gui.container.SubGui;
import com.creativemd.littletiles.common.utils.LittleTile;
import com.creativemd.littletiles.common.utils.small.LittleTileBox;
import com.creativemd.littletiles.common.utils.small.LittleTileVec;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LittleChair extends LittleStructure{

	public LittleChair() {
		
	}

	@Override
	protected void loadFromNBTExtra(NBTTagCompound nbt) {
		
	}

	@Override
	protected void writeToNBTExtra(NBTTagCompound nbt) {
			
	}
	
	@Override
	public boolean onBlockActivated(World world, LittleTile tile, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			LittleTileVec vec = getHighestCenterPoint();
			if(vec != null)
			{
				EntitySit sit = new EntitySit(world, vec.getPosX(), vec.getPosY(), vec.getPosZ());
				player.startRiding(sit);
				world.spawnEntity(sit);
			}
			
		}
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void createControls(SubGui gui, LittleStructure structure) {
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public LittleStructure parseStructure(SubGui gui) {
		return new LittleChair();
	}

}
