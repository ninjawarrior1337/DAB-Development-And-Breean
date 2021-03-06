package com.rocker1337.dab.init.items;

import com.google.common.collect.Sets;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;

/**
 * Created by Rocker545 on 7/29/2016.
 */
public class multitool extends ItemTool
{
    static float speed;

    static Item.ToolMaterial multitoolmaterial = EnumHelper.addToolMaterial("firststage", 2147483647, -1, speed, Float.intBitsToFloat(0x7f800000), 2147483647);

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH});

    //public multitool(float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn) {
        //super(8.0F, -3.0F, materialIn, EFFECTIVE_ON);
     //   super();
   // }

    public multitool()
    {
        super(multitoolmaterial, EFFECTIVE_ON);
        this.damageVsEntity = Float.intBitsToFloat(0x7f800000);
        this.attackSpeed = Float.intBitsToFloat(0x7f800000);
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setCreativeTab(DABItems.tabDAB);
        setUnlocalizedName(SetItemNames.DABItems.MULTITOOL.getUnlocalizedName());
        setRegistryName(SetItemNames.DABItems.MULTITOOL.getRegistryName());
    }

    public boolean canHarvestBlock(IBlockState blockIn) {
        Block block = blockIn.getBlock();

        if(block == Blocks.SNOW || block == Blocks.SNOW_LAYER)
        {
            return block == Blocks.SNOW_LAYER ? true : block == Blocks.SNOW;
        }

        if (block == Blocks.OBSIDIAN)
        {
            return this.toolMaterial.getHarvestLevel() >= 3;
        }

        else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE)
        {
            if (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK)
            {
                if (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE)
                {
                    if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE)
                    {
                        if (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE)
                        {
                            if (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE)
                            {
                                Material material = blockIn.getMaterial();
                                return material == Material.ROCK ? true : (material == Material.IRON ? true : material == Material.ANVIL ? true : material == Material.WOOD ? true : material == Material.PLANTS ? true : material == Material.VINE);
                            }
                            else
                            {
                                return this.toolMaterial.getHarvestLevel() >= 2;
                            }
                        }
                        else
                        {
                            return this.toolMaterial.getHarvestLevel() >= 1;
                        }
                    }
                    else
                    {
                        return this.toolMaterial.getHarvestLevel() >= 1;
                    }
                }
                else
                {
                    return this.toolMaterial.getHarvestLevel() >= 2;
                }
            }
            else
            {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        }
        else
        {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS)
            {
                IBlockState iblockstate1 = Blocks.GRASS_PATH.getDefaultState();
                worldIn.playSound(playerIn, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!worldIn.isRemote)
                {
                    worldIn.setBlockState(pos, iblockstate1, 11);
                    stack.damageItem(1, playerIn);
                }

                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.PASS;
            }
        }
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        if(state.getBlock() == Blocks.SNOW)
        {
            return stack.getTagCompound().getFloat("Speed");
        }
        return material != Material.WOOD && material != Material.PLANTS &&
                material != Material.VINE && material != Material.IRON && material != Material.ANVIL && material != Material.ROCK && material != Material.GROUND &&
                material != Material.GRASS && material != Material.SNOW && material != Material.SAND ? super.getStrVsBlock(stack, state) : stack.getTagCompound().getFloat("Speed");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced)
    {
        toolTip.add(ChatFormatting.AQUA + "Pickaxe + Shovel + Axe + Sword");
        if(stack.getTagCompound() != null) {
            toolTip.add(TextFormatting.LIGHT_PURPLE + "Speed = " + stack.getTagCompound().getFloat("Speed"));
        }
    }
    @Override
    public boolean hasEffect(ItemStack itemStack)
    {
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int metadata, boolean bool)
    {
        if(stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        if(!stack.getTagCompound().hasKey("Speed"))
        {
            stack.getTagCompound().setFloat("Speed", 15F);
        }
        speed = stack.getTagCompound().getFloat("Speed");
    }
}
