package net.citizensnpcs.npc.entity;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.CitizensMobNPC;
import net.citizensnpcs.npc.CitizensNPC;
import net.citizensnpcs.npc.CitizensNPCManager;
import net.citizensnpcs.npc.ai.NPCHandle;
import net.minecraft.server.EntityCaveSpider;
import net.minecraft.server.PathfinderGoalSelector;
import net.minecraft.server.World;

import org.bukkit.entity.CaveSpider;

public class CitizensCaveSpiderNPC extends CitizensMobNPC {

    public CitizensCaveSpiderNPC(CitizensNPCManager manager, int id, String name) {
        super(manager, id, name, EntityCaveSpiderNPC.class);
    }

    @Override
    public CaveSpider getBukkitEntity() {
        return (CaveSpider) getHandle().getBukkitEntity();
    }

    public static class EntityCaveSpiderNPC extends EntityCaveSpider implements NPCHandle {
        private final CitizensNPC npc;

        public EntityCaveSpiderNPC(World world, NPC npc) {
            super(world);
            this.npc = (CitizensNPC) npc;
            goalSelector = new PathfinderGoalSelector();
            targetSelector = new PathfinderGoalSelector();
        }

        @Override
        public void z_() {
            super.z_();
            npc.update();
        }

        @Override
        public NPC getNPC() {
            return npc;
        }
    }
}