package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateItemQualityAndSellin();
	}

	public static void updateItemQualityAndSellin()
	{
		for (int i = 0; i < items.size(); i++)
		{
			if ((!"Aged Brie".equals(getItemName(i)))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(getItemName(i)))
			{
				if (getItemQuality(i) > 0)
				{
					if (!"Sulfuras, Hand of Ragnaros".equals(getItemName(i)))
					{
						items.get(i).setQuality(getItemQuality(i) - 1);
					}
				}
			}
			else
			{
				if (getItemQuality(i) < 50)
				{
					items.get(i).setQuality(getItemQuality(i) + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(getItemName(i)))
					{
						if (getItemSellIn(i) < 11)
						{
							if (getItemQuality(i) < 50)
							{
								items.get(i).setQuality(getItemQuality(i) + 1);
							}
						}

						if (getItemSellIn(i) < 6)
						{
							if (getItemQuality(i) < 50)
							{
								items.get(i).setQuality(getItemQuality(i) + 1);
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(getItemName(i)))
			{
				items.get(i).setSellIn(getItemSellIn(i) - 1);
			}

			if (getItemSellIn(i) < 0)
			{
				if (!"Aged Brie".equals(getItemName(i)))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(getItemName(i)))
					{
						if (getItemQuality(i) > 0)
						{
							if (!"Sulfuras, Hand of Ragnaros".equals(getItemName(i)))
							{
								items.get(i).setQuality(getItemQuality(i) - 1);
							}
						}
					}
					else
					{
						items.get(i).setQuality(getItemQuality(i) - getItemQuality(i));
					}
				}
				else
				{
					if (getItemQuality(i) < 50)
					{
						items.get(i).setQuality(getItemQuality(i) + 1);
					}
				}
			}
		}
	}

	public static int getItemSellIn(int i) {
		return items.get(i).getSellIn();
	}

	public static int getItemQuality(int i) {
		return items.get(i).getQuality();
	}

	public static String getItemName(int i) {
		return items.get(i).getName();
	}

}