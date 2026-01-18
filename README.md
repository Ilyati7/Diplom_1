# Stellar Burgers - Тестирование системы заказа бургеров

## 📋 Описание проекта
Проект представляет собой систему для заказа бургеров в Stellar Burgers. Основная цель - покрытие юнит-тестами класса `Burger` с использованием библиотек Mockito, JUnit 4 и параметризации.

## 🎯 Цели проекта
- Достижение 100% покрытия кода класса `Burger`
- Использование мок-объектов (Mockito) для изоляции тестов
- Применение параметризованного тестирования
- Тестирование граничных случаев и обработки исключений

## 📊 Отчет о покрытии тестами

### Класс Burger - 100% покрытие

**Протестированные методы:**
1. `setBuns(Bun bun)` ✅
2. `addIngredient(Ingredient ingredient)` ✅
3. `removeIngredient(int index)` ✅
4. `moveIngredient(int index, int newIndex)` ✅
5. `getPrice()` ✅
6. `getReceipt()` ✅

### Статистика тестов
- **Всего тестовых классов:** 6
- **Всего тестовых методов:** 38
- **Параметризованных тестов:** 2 класса
- **Граничных случаев:** 7 тестов
- **Исключений:** 5 тестов

## 🛠 Технологический стек

### Основные библиотеки:
```xml
<dependencies>
    <!-- Тестирование -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>

    <!-- Мокирование -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>4.11.0</version>
    </dependency>
    
    <!-- Покрытие кода -->
    <dependency>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
    </dependency>
</dependencies>



Версии:
Java: 11

Maven: 3.6+

JUnit: 4.13.2

Mockito: 4.11.0


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
│   ├── BurgerCoreTest.java         # Основные тесты
│   ├── BurgerEdgeCasesTest.java    # Граничные случаи
│   ├── BurgerMoveIngredientTest.java # Тесты перемещения
│   ├── BurgerPriceParameterizedTest.java # Параметризованные тесты цены
│   └── BurgerReceiptParameterizedTest.java # Параметризованные тесты чека
├── pom.xml                         # Конфигурация Maven
└── README.md                       # Этот файл
