package com.modjk.game.exp;

import java.util.ArrayList;

public class Level
{
	public static Experience process(ArrayList<? extends LevelExp> table, int currentLevel, int maxLevel,
			int currentExp, int addExp)
	{
		if (currentLevel == 0)
		{
			currentLevel = 1;
		}

		Experience result = new Experience();

		result.add_value = addExp;

		LevelExp minLevelExp = table.get(0);
		if (minLevelExp != null)
		{
			result.min_level = minLevelExp.getLevel();
			result.min_value = minLevelExp.getNextExp();
		}

		if (maxLevel == 100)
		{
			result.max_level = 0;
		}

		LevelExp maxLevelExp = table.get(maxLevel - 1);
		if (maxLevelExp != null)
		{
			result.max_level = maxLevelExp.getLevel();
			result.max_value = maxLevelExp.getStartExp();
		}

		LevelExp currentLevelExp = table.get(currentLevel - 1);
		if (currentLevelExp != null)
		{
			result.before_level = currentLevel;
			result.before_base_value = currentLevelExp.getStartExp();
			result.before_next_value = currentLevelExp.getNextExp();
			result.before_value = currentExp;
			result.before_value_per = (float) ((double) (result.before_value - result.before_base_value)
					/ (double) (result.before_next_value - result.before_base_value)) * 100;
		}

		if ((currentExp + addExp) >= result.max_value)
		{
			result.after_level = maxLevelExp.getLevel();
			result.after_base_value = maxLevelExp.getStartExp();
			result.after_next_value = maxLevelExp.getNextExp();
			result.after_value = maxLevelExp.getStartExp();
			result.after_value_per = 0;
		} else
		{
			result.after_value = (currentExp + addExp);
			for (int level = currentLevel; level <= maxLevel; ++level)
			{
				LevelExp levelExp = table.get(level - 1);
				if (levelExp != null && result.after_value < levelExp.getNextExp())
				{
					result.after_level = levelExp.getLevel();
					result.after_base_value = levelExp.getStartExp();
					result.after_next_value = levelExp.getNextExp();
					result.after_value_per = (float) ((double) (result.after_value - result.after_base_value)
							/ (double) (result.after_next_value - result.after_base_value)) * 100;

					break;
				}
			}
		}
		result.level_up_count = result.after_level - result.before_level;

		return result;
	}

}
