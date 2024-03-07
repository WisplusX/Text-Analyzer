import {
  Divider,
  Flex,
  Heading,
  Switch,
  VStack,
  Button,
} from "@chakra-ui/react";
import { useState } from "react";

const WordsOptions = ({ onChange }) => {
  const [allOptionsEnabled, setAllOptionsEnabled] = useState(false);
  const [optionsState, setOptionsState] = useState({
    wordCount: true,
    uniqueWordCount: true,
    averageWordLength: true,
    wordsFrequency: true,
  });

  const handleEnableAllOptions = () => {
    setAllOptionsEnabled(true);
    setOptionsState({
      wordCount: true,
      uniqueWordCount: true,
      averageWordLength: true,
      wordsFrequency: true,
    });
    onChange({
      wordCount: true,
      uniqueWordCount: true,
      averageWordLength: true,
      wordsFrequency: true,
    });
  };

  const handleDisableAllOptions = () => {
    setAllOptionsEnabled(false);
    setOptionsState({
      wordCount: false,
      uniqueWordCount: false,
      averageWordLength: false,
      wordsFrequency: false,
    });
    onChange({
      wordCount: false,
      uniqueWordCount: false,
      averageWordLength: false,
      wordsFrequency: false,
    });
  };

  const handleOptionChange = (option) => (isChecked) => {
    if (!isChecked) {
      setAllOptionsEnabled(false);
    }
    setOptionsState((prevState) => {
      const newState = { ...prevState, [option]: isChecked };
      onChange(newState);
      return newState;
    });
  };

  return (
    <VStack align="start" spacing="4" my="6">
      <Flex justify="space-between" w="100%">
        <Heading size="md" mr="auto">
          Слова
        </Heading>
        <Button
          fontSize="sm"
          fontWeight="400"
          variant="link"
          onClick={handleEnableAllOptions}
          mr="4"
        >
          Увімкнути все
        </Button>
        <Button
          fontSize="sm"
          fontWeight="400"
          variant="link"
          onClick={handleDisableAllOptions}
        >
          Вимкнути все
        </Button>
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Кількість слів
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.wordCount}
          onChange={(e) => handleOptionChange("wordCount")(e.target.checked)}
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Кількість унікальних слів
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.uniqueWordCount}
          onChange={(e) =>
            handleOptionChange("uniqueWordCount")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Середня довжина слів
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.averageWordLength}
          onChange={(e) =>
            handleOptionChange("averageWordLength")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Частота використання
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.wordsFrequency}
          onChange={(e) =>
            handleOptionChange("wordsFrequency")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
    </VStack>
  );
};

export default WordsOptions;
