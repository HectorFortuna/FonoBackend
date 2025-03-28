package com.hectorfortuna.fonoBack.FonoBackend.mapper;

import com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation.*;
import com.hectorfortuna.fonoBack.FonoBackend.model.evaluation.*;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation.PatientEvaluation;
import org.springframework.stereotype.Component;

@Component
public class EvaluationMapper {
    public EvaluationDTO convertToDTO(Evaluation entity) {
        return EvaluationDTO.builder()
                .id(entity.getId())
                .patientId(entity.getPatientEvaluation() != null ? entity.getPatientEvaluation().getPatient().getId() : null)
                .gestation(convertToGestationDTO(entity.getGestation()))
                .nutrition(convertToNutritionDTO(entity.getNutrition()))
                .sleep(convertToSleepDTO(entity.getSleep()))
                .psychomotorDevelopment(convertToPsychomotorDevelopmentDTO(entity.getPsychomotorDevelopment()))
                .languageDevelopment(convertToLanguageDevelopmentDTO(entity.getLanguageDevelopment()))
                .pathologicalHistory(convertToPathologicalHistoryDTO(entity.getPathologicalHistory()))
                .independenceAndComprehension(convertToIndependenceAndComprehensionDTO(entity.getIndependenceAndComprehension()))
                .habitsAndTics(convertToHabitsAndTicsDTO(entity.getHabitsAndTics()))
                .schooling(convertToSchoolingDTO(entity.getSchooling()))
                .recreation(convertToRecreationDTO(entity.getRecreation()))
                .familyInterrelationship(convertToFamilyInterrelationshipDTO(entity.getFamilyInterrelationship()))
                .mainComplaint(entity.getMainComplaint())
                .evaluationData(entity.getEvaluationData())
                .build();
    }


    public Evaluation convertToEntity(EvaluationDTO dto, Patient patient) {
        Evaluation evaluation = Evaluation.builder()
                .gestation(convertToGestation(dto.getGestation()))
                .nutrition(convertToNutrition(dto.getNutrition()))
                .sleep(convertToSleep(dto.getSleep()))
                .psychomotorDevelopment(convertToPsychomotorDevelopment(dto.getPsychomotorDevelopment()))
                .languageDevelopment(convertToLanguageDevelopment(dto.getLanguageDevelopment()))
                .pathologicalHistory(convertToPathologicalHistory(dto.getPathologicalHistory()))
                .independenceAndComprehension(convertToIndependenceAndComprehension(dto.getIndependenceAndComprehension()))
                .habitsAndTics(convertToHabitsAndTics(dto.getHabitsAndTics()))
                .schooling(convertToSchooling(dto.getSchooling()))
                .recreation(convertToRecreation(dto.getRecreation()))
                .familyInterrelationship(convertToFamilyInterrelationship(dto.getFamilyInterrelationship()))
                .mainComplaint(dto.getMainComplaint())
                .evaluationData(dto.getEvaluationData())
                .build();

        PatientEvaluation patientEvaluation = PatientEvaluation.builder()
                .patient(patient)
                .evaluation(evaluation)
                .build();

        evaluation.setPatientEvaluation(patientEvaluation);

        return evaluation;
    }

    public Recreation convertToRecreation(RecreationDTO dto) {
        return Recreation.builder()
                .favoriteActivitiesAndToys(dto.getFavoriteActivitiesAndToys())
                .adaptsAndHasFriends(dto.getAdaptsAndHasFriends())
                .favoriteBooksAndTvShows(dto.getFavoriteBooksAndTvShows())
                .observations(dto.getObservations())
                .build();
    }

     public FamilyInterrelationship convertToFamilyInterrelationship(FamilyInterrelationshipDTO dto) {
        return FamilyInterrelationship.builder()
                .relationshipWithFather(dto.getRelationshipWithFather())
                .relationshipWithMother(dto.getRelationshipWithMother())
                .relationshipWithSiblings(dto.getRelationshipWithSiblings())
                .relationshipWithOtherRelatives(dto.getRelationshipWithOtherRelatives())
                .observations(dto.getObservations())
                .build();
    }
     public Gestation convertToGestation(GestationDTO dto) {
        return Gestation.builder()
                .gestationDuration(dto.getGestationDuration())
                .motherAge(dto.getMotherAge())
                .prenatalTreatment(dto.getPrenatalTreatment())
                .accidents(dto.getAccidents())
                .diseasesDuringPregnancy(dto.getDiseasesDuringPregnancy())
                .medicationsDuringPregnancy(dto.getMedicationsDuringPregnancy())
                .hypotension(dto.getHypotension())
                .hypertension(dto.getHypertension())
                .anemia(dto.getAnemia())
                .deliveryDuration(dto.getDeliveryDuration())
                .normalDelivery(dto.getNormalDelivery())
                .forcepsDelivery(dto.getForcepsDelivery())
                .cesareanDelivery(dto.getCesareanDelivery())
                .anesthesia(dto.getAnesthesia())
                .birthWeight(dto.getBirthWeight())
                .birthHeight(dto.getBirthHeight())
                .cried(dto.getCried())
                .cyanosis(dto.getCyanosis())
                .pregnancyExperience(dto.getPregnancyExperience())
                .coupleRelationship(dto.getCoupleRelationship())
                .maternalHealthConditions(dto.getMaternalHealthConditions())
                .postpartumExperience(dto.getPostpartumExperience())
                .motherBabyHealthPostpartum(dto.getMotherBabyHealthPostpartum())
                .postpartumDepression(dto.getPostpartumDepression())
                .firstDaysAtHome(dto.getFirstDaysAtHome())
                .observations(dto.getObservations())
                .build();
    }

     public Nutrition convertToNutrition(NutritionDTO dto) {
        return Nutrition.builder()
                .breastfeeding(dto.getBreastfeeding())
                .breastfeedingDuration(dto.getBreastfeedingDuration())
                .artificialFeeding(dto.getArtificialFeeding())
                .artificialFeedingDuration(dto.getArtificialFeedingDuration())
                .goodSuctionSwallowing(dto.getGoodSuctionSwallowing())
                .choking(dto.getChoking())
                .vomiting(dto.getVomiting())
                .forcedToEat(dto.getForcedToEat())
                .currentFeeding(dto.getCurrentFeeding())
                .observations(dto.getObservations())
                .build();
    }

     public Sleep convertToSleep(SleepDTO dto) {
        return Sleep.builder()
                .normal(dto.getNormal())
                .restless(dto.getRestless())
                .talksDuringSleep(dto.getTalksDuringSleep())
                .nocturnalEnuresis(dto.getNocturnalEnuresis())
                .teethGrinding(dto.getTeethGrinding())
                .sleepwalking(dto.getSleepwalking())
                .sleepsWithMouthOpen(dto.getSleepsWithMouthOpen())
                .drools(dto.getDrools())
                .observations(dto.getObservations())
                .build();
    }

     public PsychomotorDevelopment convertToPsychomotorDevelopment(PsychomotorDevelopmentDTO dto) {
        return PsychomotorDevelopment.builder()
                .heldHeadUp(dto.getHeldHeadUp())
                .crawled(dto.getCrawled())
                .crawledAge(dto.getCrawledAge())
                .walkedAge(dto.getWalkedAge())
                .floppyOrFirmBaby(dto.getFloppyOrFirmBaby())
                .fallingFrequency(dto.getFallingFrequency())
                .grabbedObjectsAge(dto.getGrabbedObjectsAge())
                .canJump(dto.getCanJump())
                .walkingDefects(dto.getWalkingDefects())
                .goodDirectionSense(dto.getGoodDirectionSense())
                .analAndNocturnalSphincterControl(dto.getAnalAndNocturnalSphincterControl())
                .bumpsIntoThings(dto.getBumpsIntoThings())
                .dropsThingsFromHands(dto.getDropsThingsFromHands())
                .agile(dto.getAgile())
                .orthopedicProblems(dto.getOrthopedicProblems())
                .usedBoots(dto.getUsedBoots())
                .dailyActivities(dto.getDailyActivities())
                .observations(dto.getObservations())
                .build();
    }

     public LanguageDevelopment convertToLanguageDevelopment(LanguageDevelopmentDTO dto) {
        return LanguageDevelopment.builder()
                .babbled(dto.getBabbled())
                .syllableRepetition(dto.getSyllableRepetition())
                .wordsWithMeaning(dto.getWordsWithMeaning())
                .simpleCompleteSentences(dto.getSimpleCompleteSentences())
                .understoodByAllWhen(dto.getUnderstoodByAllWhen())
                .stutteredAround(dto.getStutteredAround())
                .understandsCommands(dto.getUnderstandsCommands())
                .emitsPrimitiveSounds(dto.getEmitsPrimitiveSounds())
                .languageUnderstoodBySurroundings(dto.getLanguageUnderstoodBySurroundings())
                .usesGesturesOrMimics(dto.getUsesGesturesOrMimics())
                .sings(dto.getSings())
                .knowsSongsFromMemory(dto.getKnowsSongsFromMemory())
                .observations(dto.getObservations())
                .build();
    }

     public PathologicalHistory convertToPathologicalHistory(PathologicalHistoryDTO dto) {
        return PathologicalHistory.builder()
                .physicalMalformationsOrDefects(dto.getPhysicalMalformationsOrDefects())
                .measles(dto.getMeasles())
                .smallpox(dto.getSmallpox())
                .highFever(dto.getHighFever())
                .fallsOrBlows(dto.getFallsOrBlows())
                .psychosomaticDisorders(dto.getPsychosomaticDisorders())
                .tonsilsAndAdenoids(dto.getTonsilsAndAdenoids())
                .operationsDone(dto.getOperationsDone())
                .seesWell(dto.getSeesWell())
                .wearsGlasses(dto.getWearsGlasses())
                .optometristReason(dto.getOptometristReason())
                .optometristResult(dto.getOptometristResult())
                .hearingProblems(dto.getHearingProblems())
                .whichEar(dto.getWhichEar())
                .hearingProblemTimingAndCircumstance(dto.getHearingProblemTimingAndCircumstance())
                .prefersLoudSpeech(dto.getPrefersLoudSpeech())
                .frequentlyHoarse(dto.getFrequentlyHoarse())
                .annoyedByNoise(dto.getAnnoyedByNoise())
                .speaksVeryLoudOrVerySoft(dto.getSpeaksVeryLoudOrVerySoft())
                .understandsWell(dto.getUnderstandsWell())
                .looksAtLipsWhenListening(dto.getLooksAtLipsWhenListening())
                .howToUnderstand(dto.getHowToUnderstand())
                .attendedTherapy(dto.getAttendedTherapy())
                .observations(dto.getObservations())
                .build();
    }

     public IndependenceAndComprehension convertToIndependenceAndComprehension(IndependenceAndComprehensionDTO dto) {
        return IndependenceAndComprehension.builder()
                .startedEatingAloneAge(dto.getStartedEatingAloneAge())
                .startedDressingAloneAge(dto.getStartedDressingAloneAge())
                .startedBathingAloneAge(dto.getStartedBathingAloneAge())
                .startedIdentifyingObjectsAge(dto.getStartedIdentifyingObjectsAge())
                .observations(dto.getObservations())
                .build();
    }

     public HabitsAndTics convertToHabitsAndTics(HabitsAndTicsDTO dto) {
        return HabitsAndTics.builder()
                .usedPacifier(dto.getUsedPacifier())
                .pacifierRemovalMethod(dto.getPacifierRemovalMethod())
                .suckedThumb(dto.getSuckedThumb())
                .thumbHand(dto.getThumbHand())
                .thumbSuckingDuration(dto.getThumbSuckingDuration())
                .thumbSuckingRemovalMethod(dto.getThumbSuckingRemovalMethod())
                .bitesNails(dto.getBitesNails())
                .nailBitingHand(dto.getNailBitingHand())
                .observations(dto.getObservations())
                .build();
    }

     public Schooling convertToSchooling(SchoolingDTO dto) {
        return Schooling.builder()
                .doesWellInSchool(dto.getDoesWellInSchool())
                .likesToStudy(dto.getLikesToStudy())
                .parentsStudyWithChild(dto.getParentsStudyWithChild())
                .arithmeticDifficulties(dto.getArithmeticDifficulties())
                .writingDifficulties(dto.getWritingDifficulties())
                .hasBeenHeldBack(dto.getHasBeenHeldBack())
                .reasonForBeingHeldBack(dto.getReasonForBeingHeldBack())
                .attendedKindergarten(dto.getAttendedKindergarten())
                .kindergartenAge(dto.getKindergartenAge())
                .changedSchoolsOften(dto.getChangedSchoolsOften())
                .currentGrade(dto.getCurrentGrade())
                .currentSchool(dto.getCurrentSchool())
                .observations(dto.getObservations())
                .build();
    }

    private GestationDTO convertToGestationDTO(Gestation entity) {
        return GestationDTO.builder()
                .gestationDuration(entity.getGestationDuration())
                .motherAge(entity.getMotherAge())
                .prenatalTreatment(entity.getPrenatalTreatment())
                .accidents(entity.getAccidents())
                .diseasesDuringPregnancy(entity.getDiseasesDuringPregnancy())
                .medicationsDuringPregnancy(entity.getMedicationsDuringPregnancy())
                .hypotension(entity.getHypotension())
                .hypertension(entity.getHypertension())
                .anemia(entity.getAnemia())
                .deliveryDuration(entity.getDeliveryDuration())
                .normalDelivery(entity.getNormalDelivery())
                .forcepsDelivery(entity.getForcepsDelivery())
                .cesareanDelivery(entity.getCesareanDelivery())
                .anesthesia(entity.getAnesthesia())
                .birthWeight(entity.getBirthWeight())
                .birthHeight(entity.getBirthHeight())
                .cried(entity.getCried())
                .cyanosis(entity.getCyanosis())
                .observations(entity.getObservations())
                .pregnancyExperience(entity.getPregnancyExperience())
                .coupleRelationship(entity.getCoupleRelationship())
                .maternalHealthConditions(entity.getMaternalHealthConditions())
                .postpartumExperience(entity.getPostpartumExperience())
                .motherBabyHealthPostpartum(entity.getMotherBabyHealthPostpartum())
                .postpartumDepression(entity.getPostpartumDepression())
                .firstDaysAtHome(entity.getFirstDaysAtHome())
                .build();
    }

    private NutritionDTO convertToNutritionDTO(Nutrition entity) {
        return NutritionDTO.builder()
                .breastfeeding(entity.getBreastfeeding())
                .breastfeedingDuration(entity.getBreastfeedingDuration())
                .artificialFeeding(entity.getArtificialFeeding())
                .artificialFeedingDuration(entity.getArtificialFeedingDuration())
                .goodSuctionSwallowing(entity.getGoodSuctionSwallowing())
                .choking(entity.getChoking())
                .vomiting(entity.getVomiting())
                .forcedToEat(entity.getForcedToEat())
                .currentFeeding(entity.getCurrentFeeding())
                .observations(entity.getObservations())
                .build();
    }

    private SleepDTO convertToSleepDTO(Sleep entity) {
        return SleepDTO.builder()
                .normal(entity.getNormal())
                .restless(entity.getRestless())
                .talksDuringSleep(entity.getTalksDuringSleep())
                .nocturnalEnuresis(entity.getNocturnalEnuresis())
                .teethGrinding(entity.getTeethGrinding())
                .sleepwalking(entity.getSleepwalking())
                .sleepsWithMouthOpen(entity.getSleepsWithMouthOpen())
                .drools(entity.getDrools())
                .observations(entity.getObservations())
                .build();
    }

    private PsychomotorDevelopmentDTO convertToPsychomotorDevelopmentDTO(PsychomotorDevelopment entity) {
        return PsychomotorDevelopmentDTO.builder()
                .heldHeadUp(entity.getHeldHeadUp())
                .crawled(entity.getCrawled())
                .crawledAge(entity.getCrawledAge())
                .walkedAge(entity.getWalkedAge())
                .floppyOrFirmBaby(entity.getFloppyOrFirmBaby())
                .fallingFrequency(entity.getFallingFrequency())
                .grabbedObjectsAge(entity.getGrabbedObjectsAge())
                .canJump(entity.getCanJump())
                .walkingDefects(entity.getWalkingDefects())
                .goodDirectionSense(entity.getGoodDirectionSense())
                .analAndNocturnalSphincterControl(entity.getAnalAndNocturnalSphincterControl())
                .bumpsIntoThings(entity.getBumpsIntoThings())
                .dropsThingsFromHands(entity.getDropsThingsFromHands())
                .agile(entity.getAgile())
                .orthopedicProblems(entity.getOrthopedicProblems())
                .usedBoots(entity.getUsedBoots())
                .dailyActivities(entity.getDailyActivities())
                .observations(entity.getObservations())
                .build();
    }

    private LanguageDevelopmentDTO convertToLanguageDevelopmentDTO(LanguageDevelopment entity) {
        return LanguageDevelopmentDTO.builder()
                .babbled(entity.getBabbled())
                .syllableRepetition(entity.getSyllableRepetition())
                .wordsWithMeaning(entity.getWordsWithMeaning())
                .simpleCompleteSentences(entity.getSimpleCompleteSentences())
                .understoodByAllWhen(entity.getUnderstoodByAllWhen())
                .stutteredAround(entity.getStutteredAround())
                .understandsCommands(entity.getUnderstandsCommands())
                .emitsPrimitiveSounds(entity.getEmitsPrimitiveSounds())
                .languageUnderstoodBySurroundings(entity.getLanguageUnderstoodBySurroundings())
                .usesGesturesOrMimics(entity.getUsesGesturesOrMimics())
                .sings(entity.getSings())
                .knowsSongsFromMemory(entity.getKnowsSongsFromMemory())
                .observations(entity.getObservations())
                .build();
    }
    private PathologicalHistoryDTO convertToPathologicalHistoryDTO(PathologicalHistory entity) {
        return PathologicalHistoryDTO.builder()
                .physicalMalformationsOrDefects(entity.getPhysicalMalformationsOrDefects())
                .measles(entity.getMeasles())
                .smallpox(entity.getSmallpox())
                .highFever(entity.getHighFever())
                .fallsOrBlows(entity.getFallsOrBlows())
                .psychosomaticDisorders(entity.getPsychosomaticDisorders())
                .tonsilsAndAdenoids(entity.getTonsilsAndAdenoids())
                .operationsDone(entity.getOperationsDone())
                .seesWell(entity.getSeesWell())
                .wearsGlasses(entity.getWearsGlasses())
                .optometristReason(entity.getOptometristReason())
                .optometristResult(entity.getOptometristResult())
                .hearingProblems(entity.getHearingProblems())
                .whichEar(entity.getWhichEar())
                .hearingProblemTimingAndCircumstance(entity.getHearingProblemTimingAndCircumstance())
                .prefersLoudSpeech(entity.getPrefersLoudSpeech())
                .frequentlyHoarse(entity.getFrequentlyHoarse())
                .annoyedByNoise(entity.getAnnoyedByNoise())
                .speaksVeryLoudOrVerySoft(entity.getSpeaksVeryLoudOrVerySoft())
                .understandsWell(entity.getUnderstandsWell())
                .looksAtLipsWhenListening(entity.getLooksAtLipsWhenListening())
                .howToUnderstand(entity.getHowToUnderstand())
                .attendedTherapy(entity.getAttendedTherapy())
                .observations(entity.getObservations())
                .build();
    }

    private IndependenceAndComprehensionDTO convertToIndependenceAndComprehensionDTO(IndependenceAndComprehension entity) {
        return IndependenceAndComprehensionDTO.builder()
                .startedEatingAloneAge(entity.getStartedEatingAloneAge())
                .startedDressingAloneAge(entity.getStartedDressingAloneAge())
                .startedBathingAloneAge(entity.getStartedBathingAloneAge())
                .startedIdentifyingObjectsAge(entity.getStartedIdentifyingObjectsAge())
                .observations(entity.getObservations())
                .build();
    }

    private HabitsAndTicsDTO convertToHabitsAndTicsDTO(HabitsAndTics entity) {
        return HabitsAndTicsDTO.builder()
                .usedPacifier(entity.getUsedPacifier())
                .pacifierRemovalMethod(entity.getPacifierRemovalMethod())
                .suckedThumb(entity.getSuckedThumb())
                .thumbHand(entity.getThumbHand())
                .thumbSuckingDuration(entity.getThumbSuckingDuration())
                .thumbSuckingRemovalMethod(entity.getThumbSuckingRemovalMethod())
                .bitesNails(entity.getBitesNails())
                .nailBitingHand(entity.getNailBitingHand())
                .observations(entity.getObservations())
                .build();
    }

    private SchoolingDTO convertToSchoolingDTO(Schooling entity) {
        return SchoolingDTO.builder()
                .doesWellInSchool(entity.getDoesWellInSchool())
                .likesToStudy(entity.getLikesToStudy())
                .parentsStudyWithChild(entity.getParentsStudyWithChild())
                .arithmeticDifficulties(entity.getArithmeticDifficulties())
                .writingDifficulties(entity.getWritingDifficulties())
                .hasBeenHeldBack(entity.getHasBeenHeldBack())
                .reasonForBeingHeldBack(entity.getReasonForBeingHeldBack())
                .attendedKindergarten(entity.getAttendedKindergarten())
                .kindergartenAge(entity.getKindergartenAge())
                .changedSchoolsOften(entity.getChangedSchoolsOften())
                .currentGrade(entity.getCurrentGrade())
                .currentSchool(entity.getCurrentSchool())
                .observations(entity.getObservations())
                .build();
    }

    private RecreationDTO convertToRecreationDTO(Recreation entity) {
        return RecreationDTO.builder()
                .favoriteActivitiesAndToys(entity.getFavoriteActivitiesAndToys())
                .adaptsAndHasFriends(entity.getAdaptsAndHasFriends())
                .favoriteBooksAndTvShows(entity.getFavoriteBooksAndTvShows())
                .observations(entity.getObservations())
                .build();
    }

    private FamilyInterrelationshipDTO convertToFamilyInterrelationshipDTO(FamilyInterrelationship entity) {
        return FamilyInterrelationshipDTO.builder()
                .relationshipWithFather(entity.getRelationshipWithFather())
                .relationshipWithMother(entity.getRelationshipWithMother())
                .relationshipWithSiblings(entity.getRelationshipWithSiblings())
                .relationshipWithOtherRelatives(entity.getRelationshipWithOtherRelatives())
                .observations(entity.getObservations())
                .build();
    }

}
