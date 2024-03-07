import {
  Divider,
  Flex,
  Heading,
  Switch,
  VStack,
  Button,
} from "@chakra-ui/react";
import { useState } from "react";

const CharactersOptions = ({ onChange }) => {
  const [allOptionsEnabled, setAllOptionsEnabled] = useState(false);
  const [optionsState, setOptionsState] = useState({
    characterCount: true,
    characterCountWithoutWhitespaces: true,
    vowelsAndConsonants: true,
  });

  const handleEnableAllOptions = () => {
    setAllOptionsEnabled(true);
    setOptionsState({
      characterCount: true,
      characterCountWithoutWhitespaces: true,
      vowelsAndConsonants: true,
    });
    onChange({
      characterCount: true,
      characterCountWithoutWhitespaces: true,
      vowelsAndConsonants: true,
    });
  };

  const handleDisableAllOptions = () => {
    setAllOptionsEnabled(false);
    setOptionsState({
      characterCount: false,
      characterCountWithoutWhitespaces: false,
      vowelsAndConsonants: false,
    });
    onChange({
      characterCount: false,
      characterCountWithoutWhitespaces: false,
      vowelsAndConsonants: false,
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
          Знаки
        </Heading>
        <Button
          fontSize="sm"
          fontWeight="400"
          variant="link"
          mr="4"
          onClick={handleEnableAllOptions}
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
          Кількість знаків
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.characterCount}
          onChange={(e) =>
            handleOptionChange("characterCount")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Кількість знаків без пробілів
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={
            allOptionsEnabled || optionsState.characterCountWithoutWhitespaces
          }
          onChange={(e) =>
            handleOptionChange("characterCountWithoutWhitespaces")(
              e.target.checked
            )
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
      <Flex justify="space-between" w="100%">
        <Heading size="sm" fontWeight="400">
          Кількість голосних і приголосних
        </Heading>
        <Switch
          size="md"
          ml="8"
          isChecked={allOptionsEnabled || optionsState.vowelsAndConsonants}
          onChange={(e) =>
            handleOptionChange("vowelsAndConsonants")(e.target.checked)
          }
        />
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
    </VStack>
  );
};

export default CharactersOptions;
