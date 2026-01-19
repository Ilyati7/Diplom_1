Stellar Burgers - Тестирование системы заказа бургеров
📋 Описание проекта
Проект представляет собой систему для заказа бургеров в Stellar Burgers. Основная цель - покрытие юнит-тестами класса Burger с использованием библиотек Mockito, JUnit 4 и параметризации. Проект полностью соответствует принципу "один тест - одна проверка".

🎯 Цели проекта
Достижение 100% покрытия кода класса Burger ✅

Использование мок-объектов (Mockito) для изоляции тестов ✅

Применение параметризованного тестирования ✅

Тестирование граничных случаев и обработки исключений ✅

Соблюдение принципа "один тест - одна проверка" ✅

📊 Отчет о покрытии тестами
Класс Burger - 100% покрытие
Протестированные методы:

setBuns(Bun bun) ✅ (2 теста)

addIngredient(Ingredient ingredient) ✅ (2 теста)

removeIngredient(int index) ✅ (3 теста, включая исключение)

moveIngredient(int index, int newIndex) ✅ (4 теста)

getPrice() ✅ (6+ тестов, включая параметризованные)

getReceipt() ✅ (15+ тестов, включая параметризованные)

Статистика тестов
Всего тестовых классов: 6

Всего тестовых методов: 39

Всего запусков тестов: 58 (с учетом параметризации)

Параметризованных тестов: 2 класса

Граничных случаев: 10 тестов

Исключений: 5 тестов

Детализация:

BurgerCoreTest: 19 тестов

BurgerEdgeCasesTest: 10 тестов

BurgerMoveIngredientTest: 4 теста

BurgerPriceParameterizedTest: 1 метод × 5 параметров = 5 запусков

BurgerReceiptParameterizedTest: 5 методов × 4 параметра = 20 запусков

🛠 Технологический стек
Основные библиотеки:
xml
<dependencies>
<!-- Тестирование -->
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.13.2</version>
<scope>test</scope>
</dependency>

    <!-- Мокирование -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.11.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Покрытие кода -->
    <dependency>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
    </dependency>
    
    <!-- Улучшенные проверки -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.24.2</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Матчеры -->
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest</artifactId>
        <version>2.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
Версии:
Java: 11

Maven: 3.6+

JUnit: 4.13.2

Mockito: 4.11.0

JaCoCo: 0.8.8

📁 Структура проекта
text
stellar-burgers/
├── src/main/java/praktikum/
│   ├── Bun.java                    # Модель булочки
│   ├── Burger.java                 # Основной класс для тестирования
│   ├── Database.java               # База данных ингредиентов
│   ├── Ingredient.java             # Модель ингредиента
│   ├── IngredientType.java         # Enum типов ингредиентов
│   └── Praktikum.java              # Main класс
├── src/test/java/praktikum/
│   ├── BaseBurgerTest.java         # Базовый класс с моками
│   ├── BurgerCoreTest.java         # Основные тесты (19 методов)
│   ├── BurgerEdgeCasesTest.java    # Граничные случаи (10 методов)
│   ├── BurgerMoveIngredientTest.java # Тесты перемещения (4 метода)
│   ├── BurgerPriceParameterizedTest.java # Параметризованные тесты цены (1 метод, 5 параметров)
│   └── BurgerReceiptParameterizedTest.java # Параметризованные тесты чека (5 методов, 4 параметра)
├── pom.xml                         # Конфигурация Maven
└── README.md                       # Этот файл
🧪 Детали тестирования
1. Использование Mockito
   Все моки созданы в базовом классе BaseBurgerTest:

Булочки: blackBun, whiteBun

Соусы: hotSauce, sourCream

Начинки: cutlet, dinosaur, sausage

2. Параметризованное тестирование
   BurgerPriceParameterizedTest: тестирование расчета цены для 5 различных комбинаций ингредиентов

BurgerReceiptParameterizedTest: тестирование формирования чека для 4 различных наборов данных

3. Граничные случаи
   Пустой бургер (только булочка)

Некорректные индексы при удалении/перемещении

Перемещение элемента на ту же позицию

Точность вычислений с плавающей точкой

4. Обработка исключений
   NullPointerException при работе с неинициализированной булочкой

IndexOutOfBoundsException при неверных индексах

IllegalArgumentException во вспомогательных методах

🚀 Инструкция по запуску
1. Клонирование и настройка
   bash
   git clone <repository-url>
   cd stellar-burgers
2. Сборка проекта
   bash
   mvn clean compile
3. Запуск всех тестов
   bash
   mvn test
   Ожидаемый результат:

text
Tests run: 58, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
4. Генерация отчета о покрытии
   bash
   mvn jacoco:report
   Отчет будет доступен по пути: target/site/jacoco/index.html