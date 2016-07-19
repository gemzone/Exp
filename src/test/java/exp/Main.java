package exp;

import java.util.ArrayList;

import com.modjk.game.exp.Experience;
import com.modjk.game.exp.Level;
import com.modjk.game.exp.LevelExp;

public class Main
{
	public static class CustomExp implements LevelExp
	{
		public int level;
		public int start_exp;
		public int next_exp;

		public CustomExp(int level, int startExp, int nextExp)
		{
			this.level = level;
			this.start_exp = startExp;
			this.next_exp = nextExp;
		}

		@Override
		public int getLevel()
		{
			return level;
		}

		@Override
		public int getStartExp()
		{
			return start_exp;
		}

		@Override
		public int getNextExp()
		{
			return next_exp;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<CustomExp> levelTable = new ArrayList<>();
		levelTable.add(new CustomExp(1, 0, 100));
		levelTable.add(new CustomExp(2, 100, 200));
		levelTable.add(new CustomExp(3, 200, 300));
		levelTable.add(new CustomExp(4, 300, 400));
		
		Experience experience = Level.process(levelTable, 1, 4, 0, 123);
		
		System.out.println( "add_value:\t\t" + experience.add_value );
		System.out.println();
		System.out.println( "level_up_count:\t\t" + experience.level_up_count );
		System.out.println();
		System.out.println( "before_level:\t\t" + experience.before_level );
		System.out.println( "before_value_per:\t" + experience.before_value_per );
		System.out.println( "before_base_value:\t" + experience.before_base_value );
		System.out.println( "before_next_value:\t" + experience.before_next_value );
		System.out.println( "before_value:\t\t" + experience.before_value );
		System.out.println();
		System.out.println( "after_level:\t\t" + experience.after_level );
		System.out.println( "after_value_per:\t" + experience.after_value_per );
		System.out.println( "after_base_value:\t" + experience.after_base_value );
		System.out.println( "after_next_value:\t" + experience.after_next_value );
		System.out.println( "after_value:\t\t" + experience.after_value );
		
		
		System.out.println( "min_value:\t\t" + experience.min_value );
		System.out.println( "min_level:\t\t" + experience.min_level );
		System.out.println();
		System.out.println( "max_level:\t\t" + experience.max_level );
		System.out.println( "max_value:\t\t" + experience.max_value );
		System.out.println();
		System.out.println( experience.toJSONObject() );
		
		/*
			{
				"before_level":1,
				"before_value_per":0,
				"level_up_count":0,
				"add_value":0,
				"after_level":1,
				"before_base_value":0,
				"before_next_value":100,
				"after_base_value":0,
				"min_value":100,
				"max_level":2,
				"after_next_value":100,
				"after_value_per":0,
				"after_value":0,
				"min_level":1,
				"before_value":0,
				"max_value":100
			}
		*/
		
		
	}

}
