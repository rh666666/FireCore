package com.adole.firecore.item.custom;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MountainSplittingAxe extends AxeItem {

    public MountainSplittingAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.firecore.mountain_splitting_axe.tooltip").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.firecore.mountain_splitting_axe.tooltip2").formatted(Formatting.DARK_RED));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        int distance = 1;
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        while (distance <= 10) {
            BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), distance);
            // Spawn the lightning bolt.
            LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningBolt.setPosition(frontOfPlayer.toCenterPos());
            world.spawnEntity(lightningBolt);
            distance++;
        }

        // Nothing has changed to the item stack,
        // so we just return it how it was.
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}
