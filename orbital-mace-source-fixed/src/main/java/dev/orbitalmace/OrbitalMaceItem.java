package dev.orbitalmace;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;

/** A normal mace (smash attack, density, ...) that also calls an orbital strike on every hit. */
public class OrbitalMaceItem extends MaceItem {
    public OrbitalMaceItem(Properties properties) {
        super(properties);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHurtEnemy(stack, target, attacker);
        if (attacker.level() instanceof ServerLevel level && attacker instanceof ServerPlayer player) {
            OrbitalStrike.trigger(level, player, target.position());
        }
    }
}
