/**
 * The hand a weapon can go in.
 * 
 * @author George Shakhnazaryan
 */
public enum WeaponHand {

	/**
	 * The weapon can be equipped in either hand.
	 */
	EITHER,

	/**
	 * The weapon can only be equipped in the main hand.
	 */
	MAIN_HAND,

	/**
	 * The weapon can only be equipped in the off hand.
	 */
	OFF_HAND,

	/**
	 * The weapon requires both hands.
	 */
	BOTH;
}
