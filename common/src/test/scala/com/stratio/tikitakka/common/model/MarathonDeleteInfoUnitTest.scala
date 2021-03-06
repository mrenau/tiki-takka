/*
 * © 2017 Stratio Big Data Inc., Sucursal en España. All rights reserved.
 *
 * This software – including all its source code – contains proprietary information of Stratio Big Data Inc., Sucursal en España and may not be revealed, sold, transferred, modified, distributed or otherwise made available, licensed or sublicensed to third parties; nor reverse engineered, disassembled or decompiled, without express written authorization from Stratio Big Data Inc., Sucursal en España.
 */
package com.stratio.tikitakka.common.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{ShouldMatchers, WordSpec}
import play.api.libs.json.{JsObject, JsString, Json}

import com.stratio.tikitakka.common.model.marathon.MarathonDeleteInfo

@RunWith(classOf[JUnitRunner])
class MarathonDeleteInfoUnitTest extends WordSpec with ShouldMatchers {
  "A marathon response" should {
    "be serialized correctly" in {
      val response = MarathonDeleteInfo("theVersion1", "1223123-123-12-31-23-12")

      val result = Json.toJson(response).asInstanceOf[JsObject]
      result.fields should contain("version", JsString(response.version))
      result.fields should contain("deploymentId", JsString(response.deploymentId))
    }
    "be deserialized correctly" in {
      val expected = MarathonDeleteInfo("theVersion1", "1223123-123-12-31-23-12")
      val json = s"""{"version":"${expected.version}", "deploymentId":"${expected.deploymentId}"}"""

      val result = Json.parse(json).as[MarathonDeleteInfo]

      result should be(expected)
    }
  }
}
