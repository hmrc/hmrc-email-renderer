/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.lingua

object NameCase {

  val POST_NOMINAL_INITIALS = Seq(
    "VC",
    "GC",
    "KG",
    "LG",
    "KT",
    "LT",
    "KP",
    "GCB",
    "OM",
    "GCSI",
    "GCMG",
    "GCIE",
    "GCVO",
    "GBE",
    "CH",
    "KCB",
    "DCB",
    "KCSI",
    "KCMG",
    "DCMG",
    "KCIE",
    "KCVO",
    "DCVO",
    "KBE",
    "DBE",
    "CB",
    "CSI",
    "CMG",
    "CIE",
    "CVO",
    "CBE",
    "DSO",
    "LVO",
    "OBE",
    "ISO",
    "MVO",
    "MBE",
    "IOM",
    "CGC",
    "RRC",
    "DSC",
    "MC",
    "DFC",
    "AFC",
    "ARRC",
    "OBI",
    "DCM",
    "CGM",
    "GM",
    "IDSM",
    "DSM",
    "MM",
    "DFM",
    "AFM",
    "SGM",
    "IOM",
    "CPM",
    "QGM",
    "RVM",
    "BEM",
    "QPM",
    "QFSM",
    "QAM",
    "CPM",
    "MSM",
    "ERD",
    "VD",
    "TD",
    "UD",
    "ED",
    "RD",
    "VRD",
    "AE",
    "PC",
    "ADC",
    "QHP",
    "QHS",
    "QHDS",
    "QHNS",
    "QHC",
    "SCJ",
    "J",
    "LJ",
    "QS",
    "SL",
    "QC",
    "KC",
    "JP",
    "DL",
    "MP",
    "MSP",
    "MSYP",
    "AM",
    "AM",
    "MLA",
    "MEP",
    "DBEnv",
    "DConstMgt",
    "DREst",
    "EdD",
    "DPhil",
    "PhD",
    "DLitt",
    "DSocSci",
    "MD",
    "EngD",
    "DD",
    "LLD",
    "DProf",
    "MA",
    "MArch",
    "MAnth",
    "MSc",
    "MMORSE",
    "MMath",
    "MMathStat",
    "MPharm",
    "MPhil",
    "MSc",
    "MSci",
    "MSt",
    "MRes",
    "MEng",
    "MChem",
    "MBiochem",
    "MSocSc",
    "MMus",
    "LLM",
    "BCL",
    "MPhys",
    "MComp",
    "MAcc",
    "MFin",
    "MBA",
    "MPA",
    "MEd",
    "MEP",
    "MEnt",
    "MCGI",
    "MGeol",
    "MLitt",
    "MEarthSc",
    "MClinRes",
    "BA",
    "BSc",
    "LLB",
    "BEng",
    "MBChB",
    "FdA",
    "FdSc",
    "FdEng",
    "PgDip",
    "PgD",
    "PgCert",
    "PgC",
    "PgCLTHE",
    "AUH",
    "AKC",
    "AUS",
    "HNC",
    "HNCert",
    "HND",
    "HNDip",
    "DipHE",
    "Dip",
    "OND",
    "CertHE",
    "ACSM",
    "MCSM",
    "DIC",
    "AICSM",
    "ARSM",
    "ARCS",
    "LLB",
    "LLM",
    "BCL",
    "MJur",
    "DPhil",
    "PhD",
    "LLD",
    "DipLP",
    "FCILEx",
    "GCILEx",
    "ACILEx",
    "CQSW",
    "DipSW",
    "BSW",
    "MSW",
    "FCILT",
    "CMILT",
    "MILT",
    "CPL",
    "CTP",
    "CML",
    "PLS",
    "CTL",
    "DLP",
    "PLog",
    "EJLog",
    "ESLog",
    "EMLog",
    "JrLog",
    "Log",
    "SrLog",
    "BArch",
    "MArch",
    "ARB",
    "RIBA",
    "RIAS",
    "RIAI",
    "RSAW",
    "MB",
    "BM",
    "BS",
    "BCh",
    "BChir",
    "MRCS",
    "FRCS",
    "MS",
    "MCh.",
    "MRCP",
    "FRCP",
    "MRCPCH",
    "FRCPCH",
    "MRCPath",
    "MFPM",
    "FFPM",
    "BDS",
    "MRCPsych",
    "FRCPsych",
    "MRCOG",
    "FRCOG",
    "MCEM",
    "FCEM",
    "FRCA",
    "FFPMRCA",
    "MRCGP",
    "FRCGP",
    "BSc",
    "MScChiro",
    "MChiro",
    "MSc",
    "DC",
    "LFHOM",
    "MFHOM",
    "FFHOM",
    "FADO",
    "FBDO",
    "FCOptom",
    "MCOptom",
    "MOst",
    "DPT",
    "MCSP",
    "FCSP.",
    "SROT",
    "MSCR",
    "FSCR.",
    "CPhT",
    "RN",
    "VN",
    "RVN",
    "BVSc",
    "BVetMed",
    "VetMB",
    "BVM&S",
    "MRCVS",
    "FRCVS",
    "FAWM",
    "PGCAP",
    "PGCHE",
    "PGCE",
    "PGDE",
    "BEd",
    "NPQH",
    "QTS",
    "CSci",
    "CSciTeach",
    "RSci",
    "RSciTech",
    "CEng",
    "IEng",
    "EngTech",
    "ICTTech",
    "DEM",
    "MM",
    "CMarEng",
    "CMarSci",
    "CMarTech",
    "IMarEng",
    "MarEngTech",
    "RGN",
    "SRN",
    "RMN",
    "RSCN",
    "SEN",
    "EN",
    "RNMH",
    "RN",
    "RM",
    "RN1",
    "RNA",
    "RN2",
    "RN3",
    "RNMH",
    "RN4",
    "RN5",
    "RNLD",
    "RN6",
    "RN8",
    "RNC",
    "RN7",
    "RN9",
    "RHV",
    "RSN",
    "ROH",
    "RFHN",
    "SPAN",
    "SPMH",
    "SPCN",
    "SPLD",
    "SPHP",
    "SCHM",
    "SCLD",
    "SPCC",
    "SPDN",
    "V100",
    "V200",
    "V300",
    "LPE",
    "MSc"
  )

  val firstLetters = raw"\b(\w)".r //# Uppercase first letter of every word.
  val quoteS = raw"'(\w)\b".r //# Uppercase first letter of every word.

  def nc(name: String): String = {
    var s = name.toLowerCase()
    //# Uppercase first letter of every word.
    s = raw"\b(\w)".r.replaceAllIn(s, _.toString.toUpperCase)

    //# Uppercase first letter of every word.
    s = raw"'(\w)\b".r.replaceAllIn(s, _.toString.toLowerCase)

    // # Name case Mcs and Macs - taken straight from NameParse.pm incl. comments.
    // # Exclude names with 1-2 letters after prefix like Mack, Macky, Mace
    // # Exclude names ending in a,c,i,o, or j are typically Polish or Italian
    val macPattern = raw"\bMac[A-Za-z]{2,}[^aciozj ]\b|\bMc".r.unanchored
    if (macPattern.findAllIn(s).hasNext) {
      val p = raw"(.*)\b(Ma?c)([A-Za-z]+)(.*)".r.unanchored
      s = s match {
        case p(a, b, c, d) => a + b + c.capitalize + d
        case _             => s
      }
      s = raw"(\bMacEvicius)".r.replaceAllIn(s, "Macevicius")
      s = raw"(\bMacHado)".r.replaceAllIn(s, "Machado")
      s = raw"(\bMacHar)".r.replaceAllIn(s, "Machar")
      s = raw"(\bMacHin)".r.replaceAllIn(s, "Machin")
      s = raw"(\bMacHlin)".r.replaceAllIn(s, "Machlin")
      s = raw"(\bMacIas)".r.replaceAllIn(s, "Macias")
      s = raw"(\bMacIulis)".r.replaceAllIn(s, "Maciulis")
      s = raw"(\bMacKie)".r.replaceAllIn(s, "Mackie")
      s = raw"(\bMacKle)".r.replaceAllIn(s, "Mackle")
      s = raw"(\bMacKlin)".r.replaceAllIn(s, "Macklin")
      s = raw"(\bMacQuarie)".r.replaceAllIn(s, "Macquarie")
      s = raw"(\bMacOmber)".r.replaceAllIn(s, "Macomber")
      s = raw"(\bMacIn)".r.replaceAllIn(s, "Macin")
      s = raw"(\bMacKintosh)".r.replaceAllIn(s, "Mackintosh")
      s = raw"(\bMacKen)".r.replaceAllIn(s, "Macken")
      s = raw"(\bMacHen)".r.replaceAllIn(s, "Machen")
      s = raw"(\bMacisaac)".r.replaceAllIn(s, "MacIsaac")
      s = raw"(\bMacHiel)".r.replaceAllIn(s, "Machiel")
      s = raw"(\bMacIol)".r.replaceAllIn(s, "Maciol")
      s = raw"(\bMacKell)".r.replaceAllIn(s, "Mackell")
      s = raw"(\bMacKlem)".r.replaceAllIn(s, "Macklem")
      s = raw"(\bMacKrell)".r.replaceAllIn(s, "Mackrell")
      s = raw"(\bMacLin)".r.replaceAllIn(s, "Maclin")
      s = raw"(\bMacKey)".r.replaceAllIn(s, "Mackey")
      s = raw"(\bMacKley)".r.replaceAllIn(s, "Mackley")
      s = raw"(\bMacHell)".r.replaceAllIn(s, "Machell")
      s = raw"(\bMacHon)".r.replaceAllIn(s, "Machon")
    }
    s = raw"(\bMacmurdo)".r.replaceAllIn(s, "MacMurdo")

    // Arabic
    //s = raw"(\bAl +\b)".r.replaceAllIn(s, "al ")
    // Welsh
    s = raw"(\bAp +\b)".r.replaceAllIn(s, "ap ")
    s = raw"( Von +\b)".r.replaceAllIn(s, " von ")
    s = raw"( Van +\b)".r.replaceAllIn(s, " van ")

    // della and delle Italian
    s = raw"( Della +\b)".r.replaceAllIn(s, " della ")
    s = raw"( Delle +\b)".r.replaceAllIn(s, " delle ")

    // da, de di Italian
    s = raw"( Da +\b)".r.replaceAllIn(s, " da ")
    s = raw"( De +\b)".r.replaceAllIn(s, " de ")
    s = raw"( Di +\b)".r.replaceAllIn(s, " di ")

    // du French
    s = raw"( Du +\b)".r.replaceAllIn(s, " du ")

    // du Italian
    s = raw"( Del +\b)".r.replaceAllIn(s, " del ")

    // Dutch/French
    s = raw"( Der +\b)".r.replaceAllIn(s, " der ")

    // Italian
    s = raw"( Le +\b)".r.replaceAllIn(s, " le ")

    // French
    s = raw"( Lo +\b)".r.replaceAllIn(s, " lo ")

    // la French or La Spanish - keep  Spanish version
    s = raw"( La +\b)".r.replaceAllIn(s, " La ")

    POST_NOMINAL_INITIALS.foreach(
      n => s = s.replaceFirst(raw"(?i)\b$n" + " *$", s"$n")
    )

    s = raw"( Of +\b)".r.replaceAllIn(s, " of ")

    s = raw"( The +\b)".r.replaceAllIn(s, " the ")

    s = raw"((?i)\bon behalf of\b)".r.replaceAllIn(s, "on behalf of")

    s
  }
}
