package net.mcreator.pandora.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.pandora.PandoraModElements;

import java.util.Map;

@PandoraModElements.ModElement.Tag
public class Stonecircle2AdditionalGenerationConditionProcedure extends PandoraModElements.ModElement {
	public Stonecircle2AdditionalGenerationConditionProcedure(PandoraModElements instance) {
		super(instance, 26);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Stonecircle2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Stonecircle2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Stonecircle2AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Stonecircle2AdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return (!((world.getBlockState(new BlockPos((int) x, (int) (y - 5), (int) (z + 40)))).getBlock() == Blocks.AIR.getDefaultState().getBlock()));
	}
}
