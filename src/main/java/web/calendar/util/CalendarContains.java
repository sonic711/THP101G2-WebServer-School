package web.calendar.util;

import web.calendar.schedule.service.ScheduleService;
import web.calendar.schedule.service.impl.ScheduleServiceImpl;
import web.calendar.tag.service.TagUserDefService;
import web.calendar.tag.service.impl.TagUserDefServiceImpl;


public class CalendarContains {
    public static final TagUserDefService USERTAG_SERVICE = new TagUserDefServiceImpl();
    public static final ScheduleService SCHEDULE_SERVICE = new ScheduleServiceImpl();
}
