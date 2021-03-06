// Copyright (C) 2019 Google LLC
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.quantumsoft.qupathcloud.dao;

import com.quantumsoft.qupathcloud.entities.Series;
import com.quantumsoft.qupathcloud.entities.instance.Instance;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dao helper for filtering Qpdata and images in lists.
 */
public class DaoHelper {

  /**
   * Gets image Series list.
   *
   * @param series current Series for filtering
   * @return the image Series list
   */
  public static List<Series> getImageSeries(List<Series> series) {
    return series.stream()
        .filter((p) -> p.getModality() == null || !p.getModality().getValue1()
            .equalsIgnoreCase(Modality.QU_PATH_DATA.getValue()))
        .collect(Collectors.toList());
  }

  /**
   * Gets Qpdata Instance list.
   *
   * @param instances Instances for filtering
   * @return the Qpdata Instance list
   */
  public static List<Instance> getQpdataInstancesInDicomStore(List<Instance> instances) {
    return instances.stream()
        .filter((p) -> p.getModality() != null && p.getModality().getValue1()
            .equalsIgnoreCase(Modality.QU_PATH_DATA.getValue()))
        .collect(Collectors.toList());
  }

  private DaoHelper() {
  }
}
