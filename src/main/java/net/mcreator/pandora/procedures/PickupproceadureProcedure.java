package net.mcreator.pandora.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;

import net.mcreator.pandora.entity.SpearentityEntity;
import net.mcreator.pandora.PandoraModElements;

import java.util.Map;
import java.util.Comparator;

@PandoraModElements.ModElement.Tag
public class PickupproceadureProcedure extends PandoraModElements.ModElement {
	public PickupproceadureProcedure(PandoraModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Pickupproceadure!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Pickupproceadure!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Pickupproceadure!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Pickupproceadure!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world
				.getEntitiesWithinAABB(SpearentityEntity.CustomEntity.class,
						new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null)
				.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
			if (!(world
					.getEntitiesWithinAABB(SpearentityEntity.CustomEntity.class,
							new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).world.isRemote)
				(world.getEntitiesWithinAABB(SpearentityEntity.CustomEntity.class,
						new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null).stream()
						.sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).remove();
		}
	}
}
