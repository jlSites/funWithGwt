package com.jlsites.demo.classroom.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.jlsites.demo.classroom.client.place.AssessmentsPlace;
import com.jlsites.demo.classroom.client.place.HomePlace;
import com.jlsites.demo.classroom.client.place.HomeworkPlace;
import com.jlsites.demo.classroom.client.place.MoreAboutTeacherPlace;
import com.jlsites.demo.classroom.client.place.UploadFilesPlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ HomePlace.Tokenizer.class, HomeworkPlace.Tokenizer.class,
		AssessmentsPlace.Tokenizer.class,
		MoreAboutTeacherPlace.Tokenizer.class, UploadFilesPlace.Tokenizer.class })
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper {
}
