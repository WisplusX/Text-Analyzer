import React, { useState } from "react";
import { Flex, Box, Textarea, Button, Text } from "@chakra-ui/react";
import { IoBarChart } from "react-icons/io5";
import Header from "../Header";
import SettingsBlock from "./SettingsBlock/SettingsBlock";
import ResultsBlock from "./ResultsBlock/ResultsBlock";

const HomePage = () => {
  const [showSettings, setShowSettings] = useState(true);
  const [showResults, setShowResults] = useState(false);
  const [results, setResults] = useState(null);
  const [isTextValid, setIsTextValid] = useState(true);
  const [wordsOptions, setWordsOptions] = useState({
    wordCount: true,
    uniqueWordCount: true,
    averageWordLength: true,
    wordsFrequency: true,
  });
  const [otherOptions, setOtherOptions] = useState({
    sentenceCount: true,
    averageSentenceLength: true,
    averageReadingTime: true,
    averageSpeakingTime: true,
  });
  const [charactersOptions, setCharactersOptions] = useState({
    characterCount: true,
    characterCountWithoutWhitespaces: true,
    vowelsAndConsonants: true,
  });

  const handleWordsOptionsChange = (options) => {
    setWordsOptions(options);
  };

  const handleOtherOptionsChange = (options) => {
    setOtherOptions(options);
  };

  const handleCharactersOptionsChange = (options) => {
    setCharactersOptions(options);
  };

  const handleAnotherAnalysisClick = () => {
    setShowSettings(true);
    setShowResults(false);
  };

  const checkTextValid = (text) => {
    return text.trim().length > 0 && !/^[.!?]+(\s+[.!?]+)*$/.test(text.trim());
  };

  const handleAnalyzeClick = async () => {
    const text = document.getElementById("textarea").value;

    if (!checkTextValid(text)) {
      setIsTextValid(false);
      return;
    } else {
      setIsTextValid(true);
    }

    setShowSettings(false);
    setShowResults(true);

    // Відправлення запитів на сервер для аналізу
    try {
      // Аналіз знаків
      const charactersResponse = await fetch(
        "http://localhost:8080/api/characters",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json; charset=utf-8",
          },
          body: JSON.stringify({
            options: charactersOptions,
            text: text,
          }),
        }
      );

      // Аналіз слів
      const wordsResponse = await fetch("http://localhost:8080/api/words", {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify({
          options: wordsOptions,
          text: text,
        }),
      });

      // Інший аналіз
      const otherResponse = await fetch("http://localhost:8080/api/other", {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify({
          options: otherOptions,
          text: text,
        }),
      });

      // Отримання результатів з сервера
      const charactersData = await charactersResponse.json();
      const wordsData = await wordsResponse.json();
      const otherData = await otherResponse.json();

      setResults({
        charactersData,
        wordsData,
        otherData,
      });

      setWordsOptions({
        wordCount: true,
        uniqueWordCount: true,
        averageWordLength: true,
        wordsFrequency: true,
      });
      setOtherOptions({
        sentenceCount: true,
        averageSentenceLength: true,
        averageReadingTime: true,
        averageSpeakingTime: true,
      });
      setCharactersOptions({
        characterCount: true,
        characterCountWithoutWhitespaces: true,
        vowelsAndConsonants: true,
      });

      // Відображення результатів
      console.log(results);
    } catch (error) {
      console.error("Помилка під час відправлення запиту:", error);
    }
  };

  return (
    <Flex direction="column" maxW="880px" mx="auto">
      <Header />

      {/* Text input */}
      <Box w="100%" mt="20px">
        <Textarea
          id="textarea"
          placeholder="Введіть текст для аналізу..."
          minH="200px"
          bgColor="white"
          border="none"
          py="5"
          px="7"
        />
        {!isTextValid && (
          <Text color="red.500" mt="2">
            Некоректний текст. Будь ласка, спробуйте ще раз.
          </Text>
        )}
      </Box>

      {showSettings && (
        <>
          <Flex mt="20px" justify="flex-end" w="100%">
            <Button
              leftIcon={<IoBarChart />}
              colorScheme="teal"
              size="lg"
              onClick={handleAnalyzeClick}
            >
              Провести аналіз
            </Button>
          </Flex>
          <SettingsBlock
            onWordsOptionsChange={handleWordsOptionsChange}
            onOtherOptionsChange={handleOtherOptionsChange}
            onCharactersOptionsChange={handleCharactersOptionsChange}
          />
        </>
      )}

      {showResults && (
        <>
          <Flex mt="20px" justify="flex-end" w="100%">
            <Button
              leftIcon={<IoBarChart />}
              colorScheme="teal"
              size="lg"
              onClick={handleAnotherAnalysisClick}
            >
              Провести аналіз іншого тексту
            </Button>
          </Flex>
          <ResultsBlock results={results} />
        </>
      )}
    </Flex>
  );
};

export default HomePage;
