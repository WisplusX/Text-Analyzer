import {
  Divider,
  Flex,
  Heading,
  Switch,
  VStack,
  Button,
} from "@chakra-ui/react";
import { useState } from "react";

const OtherOptions = ({ onChange }) => {
  const [allOptionsEnabled, setAllOptionsEnabled] = useState(true);
  const [optionsState, setOptionsState] = useState({
    sentenceCount: true,
    averageSentenceLength: true,
    averageReadingTime: true,
    averageSpeakingTime: true,
  });

  const handleEnableAllOptions = () => {
    setAllOptionsEnabled(true);
    setOptionsState({
      sentenceCount: true,
      averageSentenceLength: true,
      averageReadingTime: true,
      averageSpeakingTime: true,
    });
    onChange({
      sentenceCount: true,
      averageSentenceLength: true,
      averageReadingTime: true,
      averageSpeakingTime: true,
    });
  };

  const handleDisableAllOptions = () => {
    setAllOptionsEnabled(false);
    setOptionsState({
      sentenceCount: false,
      averageSentenceLength: false,
      averageReadingTime: false,
      averageSpeakingTime: false,
    });
    onChange({
      sentenceCount: false,
      averageSentenceLength: false,
      averageReadingTime: false,
      averageSpeakingTime: false,
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
          Інше
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
          Кількість речень
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.sentenceCount}
          onChange={(e) =>
            handleOptionChange("sentenceCount")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Середня довжина речення
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.averageSentenceLength}
          onChange={(e) =>
            handleOptionChange("averageSentenceLength")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Середній час читання
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.averageReadingTime}
          onChange={(e) =>
            handleOptionChange("averageReadingTime")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Середній час публічного виступу
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.averageSpeakingTime}
          onChange={(e) =>
            handleOptionChange("averageSpeakingTime")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
    </VStack>
  );
};

export default OtherOptions;
