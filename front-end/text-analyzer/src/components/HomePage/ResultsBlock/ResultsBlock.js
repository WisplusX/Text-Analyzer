import React from "react";
import { Flex, Heading, Icon, Box } from "@chakra-ui/react";
import { IoCheckmarkCircle } from "react-icons/io5";
import ResultCard from "./ResultCard";
import WordsFrequenciesCard from "./WordFrequencyCard";

const ResultsBlock = ({ results }) => {
  if (!results) {
    return null;
  }

  const { charactersData, wordsData, otherData } = results;

  return (
    <Flex direction="column">
      <Flex align="center" my="2">
        <Icon as={IoCheckmarkCircle} boxSize="24px" mr="2" />
        <Heading size="md">Результати аналізу</Heading>
      </Flex>
      <Heading size="sm" color="gray.500" mb="4" fontWeight="400">
        Згідно увімкнених опцій
      </Heading>

      <Heading size="md" mb="4" mt="6">
        Слова
      </Heading>
      <Flex>
        <ResultCard
          value={wordsData.wordCount === -1 ? "-" : wordsData.wordCount}
          label={"Кількість слів"}
        />
        <ResultCard
          value={
            wordsData.uniqueWordCount === -1 ? "-" : wordsData.uniqueWordCount
          }
          label={"Унікальних слів"}
        />
        <ResultCard
          value={
            wordsData.averageWordLength === -1
              ? "-"
              : wordsData.averageWordLength.toFixed(2)
          }
          label={"Середня довжина слів"}
          additionalText={wordsData.averageWordLength === -1 ? "" : "символів"}
        />
      </Flex>
      <WordsFrequenciesCard
        data={wordsData.wordsFrequencyData}
        label={"Частота використання слів"}
      />

      <Heading size="md" mb="4" mt="6">
        Знаки
      </Heading>
      <Flex>
        <ResultCard
          value={
            charactersData.characterCount === -1
              ? "-"
              : charactersData.characterCount
          }
          label={"Кількість знаків"}
        />
        <ResultCard
          value={
            charactersData.characterWithoutWhitespacesCount === -1
              ? "-"
              : charactersData.characterWithoutWhitespacesCount
          }
          label={"Знаків без пробілів"}
        />
        <ResultCard
          value={
            charactersData.vowelsCount === -1 ? "-" : charactersData.vowelsCount
          }
          label={"Голосних"}
        />
        <ResultCard
          value={
            charactersData.consonantsCount === -1
              ? "-"
              : charactersData.consonantsCount
          }
          label={"Приголосних"}
        />
      </Flex>

      <Heading size="md" mb="4" mt="6">
        Інше
      </Heading>
      <Flex>
        <ResultCard
          value={otherData.sentenceCount === -1 ? "-" : otherData.sentenceCount}
          label={"Кількість речень"}
        />
        <ResultCard
          value={
            isFinite(otherData.averageSentenceLength)
              ? otherData.averageSentenceLength !== -1
                ? otherData.averageSentenceLength.toFixed(2)
                : "-"
              : "0"
          }
          label={"Середня довжина речення"}
          additionalText={otherData.averageSentenceLength !== -1 ? "слів" : ""}
        />
      </Flex>
      <Flex>
        <ResultCard
          value={
            otherData.averageReadingTime !== -1
              ? otherData.averageReadingTime < 60
                ? "<1"
                : Math.round(otherData.averageReadingTime / 60)
              : "-"
          }
          label={"Середній час читання"}
          additionalText={otherData.averageReadingTime !== -1 ? "хв" : ""}
        />
        <ResultCard
          value={
            otherData.averageSpeakingTime !== -1
              ? otherData.averageSpeakingTime < 60
                ? "<1"
                : Math.round(otherData.averageSpeakingTime / 60)
              : "-"
          }
          label={"Середній час виступу"}
          additionalText={otherData.averageSpeakingTime !== -1 ? "хв" : ""}
        />
      </Flex>

      <Box mb="10" />
    </Flex>
  );
};

export default ResultsBlock;
