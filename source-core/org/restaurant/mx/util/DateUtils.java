/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restaurant.mx.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author JAST
 */
public class DateUtils {
    private static Calendar CALENDAR = Calendar.getInstance();

	private DateUtils() {
	}

	public static Date getToday() {
		return getDate(new Date());
	}

	public static Date getTodayComplete() {
		return Calendar.getInstance().getTime();
	}

	public static Date getDate(Date d) {
		GregorianCalendar ddate = new GregorianCalendar();
		ddate.setTime(d);
		GregorianCalendar ddateday = new GregorianCalendar(ddate.get(GregorianCalendar.YEAR),
				ddate.get(GregorianCalendar.MONTH),
				ddate.get(GregorianCalendar.DAY_OF_MONTH));
		return ddateday.getTime();
	}

	public static Date getTodayMinutes() {
		return getDatetimeMinutes(new Date());
	}

	public static Date getDatetimeMinutes(Date d) {
		GregorianCalendar ddate = new GregorianCalendar();
		ddate.setTime(d);
		GregorianCalendar ddateday = new GregorianCalendar(ddate.get(GregorianCalendar.YEAR),
				ddate.get(GregorianCalendar.MONTH),
				ddate.get(GregorianCalendar.DAY_OF_MONTH),
				ddate.get(GregorianCalendar.HOUR_OF_DAY),
				ddate.get(GregorianCalendar.MINUTE));
		return ddateday.getTime();
	}

	public static Date getDatetimeHours(Date d) {
		Calendar ddate = Calendar.getInstance();
		ddate.setTime(d);

		Calendar dNow = Calendar.getInstance();
		dNow.clear();
		dNow.set(ddate.get(Calendar.YEAR), 
				ddate.get(Calendar.MONTH), 
				ddate.get(Calendar.DAY_OF_MONTH), 
				ddate.get(Calendar.HOUR_OF_DAY), 0, 0);

		return dNow.getTime();
	}

	public static Date getDate(Date day, Date hour) {
		// Calculamos el dia actual con la hora escogida.
		Calendar dDay = Calendar.getInstance();
		dDay.setTime(day);
		Calendar dHour = Calendar.getInstance();
		dHour.setTime(hour);

		Calendar dNow = Calendar.getInstance();
		dNow.clear();
		dNow.set(dDay.get(Calendar.YEAR), 
				dDay.get(Calendar.MONTH), 
				dDay.get(Calendar.DAY_OF_MONTH), 
				dHour.get(Calendar.HOUR_OF_DAY), 
				dHour.get(Calendar.MINUTE), 
				dHour.get(Calendar.SECOND));

		return dNow.getTime();
	}

	/**
	 * Returns the last millisecond of the specified date.
	 *
	 * @param date Date to calculate end of day from
	 * @return Last millisecond of <code>date</code>
	 */
	public static Date endOfDay(Date date) {
		Calendar calendar = CALENDAR;
		synchronized (calendar) {
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MILLISECOND, 999);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MINUTE, 59);
			return calendar.getTime();
		}
	}

	/**
	 * Returns a new Date with the hours, milliseconds, seconds and minutes set
	 * to 0.
	 *
	 * @param date Date used in calculating start of day
	 * @return Start of <code>date</code>
	 */
	public static Date startOfDay(Date date) {
		Calendar calendar = CALENDAR;
		synchronized (calendar) {
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			return calendar.getTime();
		}
	}

	public static Date startOfMonth(Date date) {
		Calendar calendar = CALENDAR;
		synchronized (calendar) {
			calendar.setTime(date);
			calendar.set(Calendar.DATE, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			return calendar.getTime();
		}
	}

	public static Date endOfMonth(Date date) {
		Calendar calendar = CALENDAR;
		synchronized (calendar) {
			calendar.setTime(date);
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MILLISECOND, 999);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MINUTE, 59);
			return calendar.getTime();
		}
	}

	public static Date startOfToday() {
		return startOfDay(new Date());
	}
	
	public static Date endOfToday() {
		return endOfDay(new Date());
	}
}
