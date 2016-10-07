import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Date {
	int day;
	int month;
	int year;

	public Date(String value) throws InputMismatchException {
		int day, month, year;
		Pattern.matches("[0-9]{2}-[0-9]{3}-[0-9]{4}", value);
		String parts[] = value.split("-");
		day = Integer.parseInt(parts[0]);
		month = Integer.parseInt(parts[1]);
		year = Integer.parseInt(parts[2]);
		Boolean flag = false;
		if (year < 9999 && day > 0)
			if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
					&& day <= 31)
				flag = true;
			else if (month != 2 && month < 12 && day <= 30)
				flag = true;
			else if (month == 2)
				if (year % 4 == 0) {
					if (day <= 29)
						flag = true;
				} else if (day <= 28)
					flag = true;
		if (flag == true) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else
			throw new InputMismatchException("Date Invalid");
	}
	@Override
	public String toString() {
		return (String.format("%02d", day) + "-" + String.format("%02d", month) + "-" + String.format("%04d", year));
	}
}
