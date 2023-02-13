import XCTest
@testable import swift_version

final class swift_versionTests: XCTestCase {
    func testExample() throws {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct
        // results.
        XCTAssertEqual(swift_version().text, "Hello, World!")
    }
}
