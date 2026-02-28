// ============================================
// Main JavaScript File
// ============================================

/**
 * Initialize when DOM is fully loaded
 */
document.addEventListener('DOMContentLoaded', function() {
    console.log('Springmvcboot Application Loaded');

    // Initialize tooltips
    initializeTooltips();

    // Initialize navigation highlights
    highlightCurrentPage();
});

/**
 * Initialize tooltips
 */
function initializeTooltips() {
    const tooltips = document.querySelectorAll('[data-tooltip]');
    tooltips.forEach(element => {
        element.addEventListener('mouseenter', showTooltip);
        element.addEventListener('mouseleave', hideTooltip);
    });
}

/**
 * Show tooltip on hover
 */
function showTooltip(e) {
    const tooltipText = e.target.getAttribute('data-tooltip');
    const tooltip = document.createElement('div');
    tooltip.className = 'tooltip';
    tooltip.textContent = tooltipText;
    tooltip.style.position = 'absolute';
    tooltip.style.backgroundColor = '#333';
    tooltip.style.color = 'white';
    tooltip.style.padding = '5px 10px';
    tooltip.style.borderRadius = '4px';
    tooltip.style.zIndex = '1000';
    document.body.appendChild(tooltip);
}

/**
 * Hide tooltip
 */
function hideTooltip() {
    const tooltip = document.querySelector('.tooltip');
    if (tooltip) {
        tooltip.remove();
    }
}

/**
 * Highlight current page in navigation
 */
function highlightCurrentPage() {
    const currentPage = window.location.pathname;
    const navLinks = document.querySelectorAll('.navbar a');

    navLinks.forEach(link => {
        if (link.getAttribute('href') === currentPage) {
            link.style.color = '#3498db';
            link.style.fontWeight = 'bold';
        }
    });
}

/**
 * Make API call
 * @param {string} url - API endpoint
 * @param {string} method - HTTP method (GET, POST, PUT, DELETE)
 * @param {object} data - Request data
 * @returns {Promise}
 */
async function apiCall(url, method = 'GET', data = null) {
    const options = {
        method: method,
        headers: {
            'Content-Type': 'application/json',
        }
    };

    if (data && (method === 'POST' || method === 'PUT')) {
        options.body = JSON.stringify(data);
    }

    try {
        const response = await fetch(url, options);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error('API call failed:', error);
        throw error;
    }
}

/**
 * Log message with timestamp
 * @param {string} message - Message to log
 */
function logMessage(message) {
    const timestamp = new Date().toLocaleTimeString();
    console.log(`[${timestamp}] ${message}`);
}

/**
 * Show success notification
 * @param {string} message - Success message
 */
function showSuccessNotification(message) {
    console.log('✓ Success: ' + message);
    // Can be enhanced with toast notifications
}

/**
 * Show error notification
 * @param {string} message - Error message
 */
function showErrorNotification(message) {
    console.error('✗ Error: ' + message);
    // Can be enhanced with toast notifications
}

// Export functions for use in other scripts
window.springmvcboot = {
    apiCall,
    logMessage,
    showSuccessNotification,
    showErrorNotification
};

