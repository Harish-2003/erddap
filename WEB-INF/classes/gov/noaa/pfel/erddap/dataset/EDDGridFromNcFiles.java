/*
 * EDDGridFromNcFiles Copyright 2009, NOAA.
 * See the LICENSE.txt file in this file's directory.
 */
package gov.noaa.pfel.erddap.dataset;

import com.cohort.array.Attributes;
import com.cohort.array.StringArray;
import gov.noaa.pfel.erddap.dataset.metadata.LocalizedAttributes;
import gov.noaa.pfel.erddap.variable.AxisVariableInfo;
import gov.noaa.pfel.erddap.variable.DataVariableInfo;
import java.util.List;

/**
 * This class represents gridded data aggregated from a collection of NetCDF .nc
 * (https://www.unidata.ucar.edu/software/netcdf/), GRIB .grb (https://en.wikipedia.org/wiki/GRIB),
 * (and related) NetcdfFiles.
 *
 * @author Bob Simons (was bob.simons@noaa.gov, now BobSimons2.00@gmail.com) 2009-01-05
 */
public class EDDGridFromNcFiles extends EDDGridFromNcLow {

  /** subclasses have different classNames. */
  @Override
  public String subClassName() {
    return "EDDGridFromNcFiles";
  }

  /**
   * Subclasses overwrite this: EDDGridFromNcFilesUnpacked applies scale_factor and add_offset and
   * converts times variables to epochSeconds.
   */
  @Override
  public boolean unpack() {
    return false;
  }

  /** subclasses call lower version */
  public static String generateDatasetsXml(
      String tFileDir,
      String tFileNameRegex,
      String sampleFileName,
      String tGroup,
      String tDimensionsCSV,
      int tReloadEveryNMinutes,
      String tCacheFromUrl,
      Attributes externalAddGlobalAttributes)
      throws Throwable {

    return generateDatasetsXml(
        "EDDGridFromNcFiles",
        tFileDir,
        tFileNameRegex,
        sampleFileName,
        tGroup,
        tDimensionsCSV,
        tReloadEveryNMinutes,
        tCacheFromUrl,
        externalAddGlobalAttributes);
  }

  /** The constructor just calls the super constructor. */
  public EDDGridFromNcFiles(
      String tDatasetID,
      String tAccessibleTo,
      String tGraphsAccessibleTo,
      boolean tAccessibleViaWMS,
      StringArray tOnChange,
      String tFgdcFile,
      String tIso19115File,
      String tDefaultDataQuery,
      String tDefaultGraphQuery,
      LocalizedAttributes tAddGlobalAttributes,
      List<AxisVariableInfo> tAxisVariables,
      List<DataVariableInfo> tDataVariables,
      int tReloadEveryNMinutes,
      int tUpdateEveryNMillis,
      String tFileDir,
      String tFileNameRegex,
      boolean tRecursive,
      String tPathRegex,
      String tMetadataFrom,
      int tMatchAxisNDigits,
      boolean tFileTableInMemory,
      boolean tAccessibleViaFiles,
      int tnThreads,
      boolean tDimensionValuesInMemory,
      String tCacheFromUrl,
      int tCacheSizeGB,
      String tCachePartialPathRegex)
      throws Throwable {

    super(
        "EDDGridFromNcFiles",
        tDatasetID,
        tAccessibleTo,
        tGraphsAccessibleTo,
        tAccessibleViaWMS,
        tOnChange,
        tFgdcFile,
        tIso19115File,
        tDefaultDataQuery,
        tDefaultGraphQuery,
        tAddGlobalAttributes,
        tAxisVariables,
        tDataVariables,
        tReloadEveryNMinutes,
        tUpdateEveryNMillis,
        tFileDir,
        tFileNameRegex,
        tRecursive,
        tPathRegex,
        tMetadataFrom,
        tMatchAxisNDigits,
        tFileTableInMemory,
        tAccessibleViaFiles,
        tnThreads,
        tDimensionValuesInMemory,
        tCacheFromUrl,
        tCacheSizeGB,
        tCachePartialPathRegex);
  }
}
