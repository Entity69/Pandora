
package net.mcreator.pandora.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.pandora.procedures.HammerHeadEntityIsHurtProcedure;
import net.mcreator.pandora.PandoraModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@PandoraModElements.ModElement.Tag
public class HammerHeadEntity extends PandoraModElements.ModElement {
	public static EntityType entity = null;
	public HammerHeadEntity(PandoraModElements instance) {
		super(instance, 31);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(3.9999999999999996f, 4f))
						.build("hammer_head").setRegistryName("hammer_head");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -16724788, -16750900, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("hammer_head"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelhammerhead(), 2f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pandora:textures/hammerheadtexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new EatGrassGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pandora:hammersounds2"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("pandora:hammersounds1"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				HammerHeadEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelhammerhead extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer leg4;
		private final ModelRenderer leg3;
		private final ModelRenderer leg5;
		private final ModelRenderer leg6;
		private final ModelRenderer leg31;
		private final ModelRenderer leg2;
		private final ModelRenderer head;
		public Modelhammerhead() {
			textureWidth = 128;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(-28, 54).addBox(-13.0F, -44.0F, -22.0F, 26.0F, 22.0F, 52.0F, 4.0F, false);
			body.setTextureOffset(69, 29).addBox(-7.0F, -47.0F, -19.0F, 14.0F, -8.0F, 15.0F, 7.0F, false);
			body.setTextureOffset(76, 75).addBox(0.0F, -61.0F, -18.0F, 0.0F, 5.0F, 23.0F, 3.0F, false);
			body.setTextureOffset(31, 77).addBox(-1.5F, -44.0F, 33.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-16.0F, -27.0F, -1.0F);
			body.addChild(leg4);
			leg4.setTextureOffset(91, 77).addBox(0.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
			leg4.setTextureOffset(78, 77).addBox(-3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-16.0F, -27.0F, -16.0F);
			body.addChild(leg3);
			leg3.setTextureOffset(91, 77).addBox(0.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
			leg3.setTextureOffset(78, 77).addBox(-3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);
			leg5 = new ModelRenderer(this);
			leg5.setRotationPoint(16.0F, -27.0F, -1.0F);
			body.addChild(leg5);
			leg5.setTextureOffset(91, 77).addBox(6.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
			leg5.setTextureOffset(78, 77).addBox(3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);
			leg6 = new ModelRenderer(this);
			leg6.setRotationPoint(16.0F, -27.0F, -16.0F);
			body.addChild(leg6);
			leg6.setTextureOffset(91, 77).addBox(6.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
			leg6.setTextureOffset(78, 77).addBox(3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);
			leg31 = new ModelRenderer(this);
			leg31.setRotationPoint(16.0F, -5.0F, 23.0F);
			leg31.setTextureOffset(123, 0).addBox(6.0F, -1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 7.0F, false);
			leg31.setTextureOffset(121, 0).addBox(4.0F, 13.0F, -1.0F, -2.0F, 11.0F, 3.0F, 5.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-16.0F, -5.0F, 23.0F);
			leg2.setTextureOffset(123, 0).addBox(0.0F, -1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 7.0F, false);
			leg2.setTextureOffset(121, 0).addBox(-2.0F, 13.0F, -1.0F, -2.0F, 11.0F, 3.0F, 5.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-1.0F, -13.0F, -24.0F);
			setRotationAngle(head, 0.1309F, 0.0F, 0.0F);
			head.setTextureOffset(15, 29).addBox(-4.0F, -5.0F, -23.0F, 10.0F, 10.0F, 15.0F, 6.0F, false);
			head.setTextureOffset(15, 19).addBox(-20.0F, -7.5513F, -34.4395F, 43.0F, 1.0F, 1.0F, 5.0F, false);
			head.setTextureOffset(15, 0).addBox(-7.0F, 11.861F, -24.8917F, 16.0F, 1.0F, 6.0F, 1.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leg31.render(matrixStack, buffer, packedLight, packedOverlay);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg5.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg6.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg31.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
